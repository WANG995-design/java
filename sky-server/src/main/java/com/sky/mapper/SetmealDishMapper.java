package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品 ID 集合查询对应的套餐 ID 集合
     */
    List<Long> getSetmealIdsByDishIds(@Param("dishIds") List<Long> dishIds);
}