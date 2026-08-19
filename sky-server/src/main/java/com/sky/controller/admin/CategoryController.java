package com.sky.controller.admin;

import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    /*
    *
    * */
    @GetMapping("/page")
    @ApiOperation("分类分页查询实现")
    public Result<PageResult> categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO){

        // 编写日志
        log.info("分类分页查询：{}"+categoryPageQueryDTO );

        //请求service层实现功能
        PageResult pageResult = categoryService.categoryPageQuery(categoryPageQueryDTO);

        return  Result.success(pageResult);
    }

    /**
     * 状态查询 post  josn  转化为  java 语句 Pathvl
     * Long id
     */
    @PostMapping("/status/{status}")
    @ApiOperation(value = "状态改变")
    public Result statusChange(@PathVariable("status") Integer status, Long id){
        log.info("查询改变状态：id={}，status-{}"+ id +status);

        categoryService.statusChange(status, id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类："+categoryDTO);
       categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @PostMapping
    @ApiOperation("新增分类")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO){

        log.info("新增分类："+categoryDTO);

        categoryService.addCategory(categoryDTO);

        return  Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除")
    public Result delCategory(Long id){
        log.info("删除分类：" + id);
        categoryService.delCategory(id);
        return  Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询")
    public Result<List<Category>>  QueryType(Integer type){

        log.info("根据类型查询数据"+ type);
        List<Category> list =  categoryService.QueryType(type);

        return  Result.success(list);
    }
}
