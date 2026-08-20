package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    PageResult dishPageQ(DishPageQueryDTO dishPageQueryDTO);

    DishVO dishQuery(Long id);

    void dishAdd(DishDTO dishDTO);

    void dishStatus(Integer status, Long id);

    void del(List<Long> id);
}
