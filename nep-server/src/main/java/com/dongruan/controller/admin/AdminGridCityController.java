package com.dongruan.controller.admin;

import com.dongruan.ENTITY.GridCity;
import com.dongruan.result.Result;
import com.dongruan.service.GridCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员端市信息相关接口")
@Slf4j
public class AdminGridCityController {
    @Autowired
    private GridCityService gridCityService;

    /**
     * 查询所有市
     * @return
     */
    @GetMapping("/gridCity/listGridCityByProvinceId")
    @ApiOperation("查询所有市")
    public Result<List<GridCity>> listGridCityByProvinceId(){
        List<GridCity> list = gridCityService.listGridCity();
        return Result.success(list);
    }


}
