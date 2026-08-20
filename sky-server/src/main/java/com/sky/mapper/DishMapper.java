package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

@Mapper
public interface DishMapper {

    /**
     * 根据分类 ID 查询关联的菜品数量
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    Page<Dish> DishPageQuery(DishPageQueryDTO dishPageQueryDTO);

    void DishStatus(Integer status, Long id);
}
