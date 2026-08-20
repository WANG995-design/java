package com.sky.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Employee;
import com.sky.mapper.DishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Override
    public PageResult DishPageQuery(DishPageQueryDTO dishPageQueryDTO) {

        // 这是获取 页数  和  record 数据
        PageHelper.startPage(dishPageQueryDTO.getPage() , dishPageQueryDTO.getPageSize());

        Page<Dish> page = dishMapper.DishPageQuery(dishPageQueryDTO);

        Long total = page.getTotal();

        return new PageResult(total, page.getResult());
    }

    @Override
    public void DishStatus(Integer status, Long id) {

        dishMapper.DishStatus(status,id);

    }
}
