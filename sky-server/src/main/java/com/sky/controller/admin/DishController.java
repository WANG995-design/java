package com.sky.controller.admin;

import com.github.pagehelper.Page;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.simpleframework.xml.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api("菜单功能的实现")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/page")
    public Result<PageResult> dishPageQ(DishPageQueryDTO dishPageQueryDTO){

        log.info("分页查询功能："+dishPageQueryDTO);

        // 他需要接受service 传过来的两个参数的总和
      PageResult pageResult =  dishService.dishPageQ(dishPageQueryDTO);

        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询菜品")
    public Result<DishVO> dishQuery(@PathVariable Long id){

        log.info("根据id查询菜品，{}",id);

        DishVO result = dishService.dishQuery(id);

        return  Result.success(result);

    }


    @PostMapping
    @ApiOperation("新增菜品")
    public Result dishAdd(@RequestBody DishDTO dishDTO){

        log.info("新增菜品：",dishDTO);

        dishService.dishAdd(dishDTO);

        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("状态")
    public Result dishStatus(@PathVariable("status") Integer status , Long id){

        dishService.dishStatus(status,id);
        return  Result.success();
    }

    @DeleteMapping
    @ApiOperation("批量删除")
    public Result del(@RequestParam List<Long> ids){
        dishService.del(ids);
        return Result.success();
    }
}
