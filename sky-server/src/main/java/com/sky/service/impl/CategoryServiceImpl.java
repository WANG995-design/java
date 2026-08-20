package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SetmealMapper setmealMapper;

    @Autowired
    private DishMapper dishMapper;

    @Override
    public PageResult categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {

        // 开始分页查询  页面  和 大小

        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());

        Page<Category> pageResult = categoryMapper.pageQuery(categoryPageQueryDTO);

        Long tolal = pageResult.getTotal();

        List<Category> record = pageResult.getResult();

        return new PageResult(tolal ,record);


        /* PageHelper.startPage(categoryPageQueryDTO.getPage() , categoryPageQueryDTO.getPageSize());

       Page<Category>  page= categoryMapper.pageQuery(categoryPageQueryDTO);
       Long total = page.getTotal();
        List<Category> record = page.getResult();
        return new PageResult(total,record);*/
    }

    @Override
    public void statusChange(Integer status, Long id) {
        Category category = Category.builder()
                .id(id)
                .status(status)
                .updateTime(LocalDateTime.now())
                .updateUser(BaseContext.getCurrentId())
                .build();
        categoryMapper.update(category);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO ,category);
        category.builder().
                updateTime(LocalDateTime.now()).
                updateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category  = new Category();
        // 拷贝前端来的信息
        BeanUtils.copyProperties(categoryDTO ,category);

        category.setStatus(0);
        //  添加时间 创建人
        category.setCreateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());

        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.insert(category);
    }

    /**
     * 根据 ID 删除分类（加入安全校验）
     */
    @Override
    public void delCategory(Long id) {
        // 校验 1：查询当前分类是否关联了菜品，如果关联了就抛出业务异常
        Integer count = dishMapper.countByCategoryId(id);
        if (count > 0) {
            // 当前分类下有菜品，不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }

        // 校验 2：查询当前分类是否关联了套餐，如果关联了就抛出业务异常
        count = setmealMapper.countByCategoryId(id);
        if (count > 0) {
            // 当前分类下有套餐，不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }

        // 校验通过，执行删除分类数据
        categoryMapper.delById(id);
    }

    @Override
    public List<Category> QueryType(Integer type) {
       List<Category>  list = categoryMapper.QueryType(type);
        return  list ;
    }
}
