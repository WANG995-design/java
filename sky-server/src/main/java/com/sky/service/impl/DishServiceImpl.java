package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishMapper;
import com.sky.mapper.FlavorMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private FlavorMapper dishFlavorMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;
    @Override
    public PageResult dishPageQ(DishPageQueryDTO dishPageQueryDTO) {

        // 获取数据
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());

        // 获取数据
        Page<DishVO> pages= dishMapper.dishPageQuery(dishPageQueryDTO);

        // 将数据传输到controller
        long page = pages.getTotal();

        List records = pages.getResult();


        return new PageResult(page,records);
    }

    @Override
    public DishVO dishQuery(Long id) {

   DishVO dishVO = dishMapper.dishQuery(id);
        return dishVO;
    }

    // 新增菜品
    @Transactional  //开启注解事务管理
    @Override
    public void dishAdd(DishDTO dishDTO) {
        Dish dish = new Dish();

        // 将dto 中的数据保存到

        // dish  flavor 两个数据库表中
     BeanUtils.copyProperties(dishDTO,dish);
        // 先保存 dish
     dishMapper.saveDish(dish);

     // 获取inset语句生成的主键值
     Long dishId = dish.getId();
        // 口味biao
        List<DishFlavor> flavors = dishDTO.getFlavors();

        if (flavors != null && !flavors.isEmpty()) {
            flavors.forEach(flavor -> {
                flavor.setDishId(dishId); // 1. DishId 应为保存菜品后获取的小写变量名 dishId
            });
            dishFlavorMapper.insertBatch(flavors);
    }
     // 开始口味的选择保存

    }

    @Override
    public void dishStatus(Integer status, Long id) {

        dishMapper.dishStatus(status,id);


    }

    @Transactional
    @Override
    public void del( List<Long> ids) {

        // 删除先删除 flavor 在删除 dish

        // 校验 1：判断菜品是否处于起售状态
        for (Long id : ids) {
            Dish dish = dishMapper.getById(id);
            if (dish.getStatus() == 1) { // 1 代表起售中
                throw new DeletionNotAllowedException("起售中的菜品不能删除");
            }
        }

        // 校验 2：判断菜品是否被套餐关联
        List<Long> setmealIds = setmealDishMapper.getSetmealIdsByDishIds(ids);
        if (setmealIds != null && setmealIds.size() > 0) {
            throw new DeletionNotAllowedException("当前菜品被套餐关联，无法删除");
        }

        // ----------------- 第二步：执行批量删除 -----------------

        // 1. 批量删除菜品表关联的口味数据 (SQL: delete from dish_flavor where dish_id in (...))
        dishFlavorMapper.deleteByDishIds(ids);

        // 2. 批量删除菜品表数据 (SQL: delete from dish where id in (...))
        dishMapper.deleteByIds(ids);
    }


}
