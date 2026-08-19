package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {

    PageResult categoryPageQuery(CategoryPageQueryDTO categoryDTO);

    void statusChange(Integer status, Long id);

    void updateCategory(CategoryDTO categoryDTO);

    void addCategory(CategoryDTO categoryDTO);

    void delCategory(Long id);

    List<Category> QueryType(Integer type);
}
