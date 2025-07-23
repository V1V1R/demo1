package com.dongruan.controller.admin;

import com.dongruan.ENTITY.Aqi;
import com.dongruan.result.Result;
import com.dongruan.service.AqiService;
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
@Api(tags = "管理员端AQI相关接口")
@Slf4j
public class AdminAqiController {
    @Autowired
    private AqiService aqiService;


    /**
     * 查询所有aqi
     * @return
     */
    @GetMapping("/aqi/listAqiAll")
    @ApiOperation("查询所有aqi")
    public Result<List<Aqi>> listAqiAll(){
        List<Aqi> list = aqiService.listAqiAll();
        return Result.success(list);
    }

}
