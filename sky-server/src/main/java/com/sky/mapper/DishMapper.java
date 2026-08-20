package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类 ID 查询关联的菜品数量
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    Page<DishVO> dishPageQuery(DishPageQueryDTO dishPageQueryDTO);

    DishVO dishQuery(Long id);

    @Insert("insert into dish (category_id, name, price, image, description, status, create_time, update_time, create_user, update_user) " +
            "values (#{categoryId}, #{name}, #{price}, #{image}, #{description}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveDish(Dish dish);

    @Update("update dish set status = #{status} where id = #{id}")
    void dishStatus(@Param("status") Integer status, @Param("id") Long id);

    void deleteByIds(@Param("ids") List<Long> ids);

    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);
}
