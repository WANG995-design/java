package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FlavorMapper {

    // 批量插入口味数据
    void insertBatch(List<DishFlavor> flavor);

    void deleteByDishIds(@Param("dishIds") List<Long> ids);
}
