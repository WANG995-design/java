package com.sky.service;

import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

public interface DishService {
    PageResult DishPageQuery(DishPageQueryDTO dishPageQueryDTO);

    void DishStatus(Integer status, Long id);
}
