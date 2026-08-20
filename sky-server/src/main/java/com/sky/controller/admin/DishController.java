package com.sky.controller.admin;

import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/dish")
@RestController
@Slf4j
@Api(tags = "菜品功能的实现")
public class DishController {

    // 载入配置
    @Autowired
    private DishService dishService;

    /*
    *
    * private long total; //总记录数

    private List records; //当前页数据集合
    * */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> DistPageQuery(DishPageQueryDTO dishPageQueryDTO){

        log.info("菜品页面显示");

       PageResult result =    dishService.DishPageQuery(dishPageQueryDTO);

        return Result.success(result);
    }

    @PostMapping("/status/{status}")
    @ApiOperation("状态按钮")
    public Result  DishStatus(@PathVariable("status") Integer status , Long id ){

        log.info("改变状态：{}{}",id,status);

        dishService.DishStatus(status, id);

        return  Result.success();
    }


}
