package com.dongruan.controller.admin;

import com.dongruan.ENTITY.GridProvince;
import com.dongruan.result.Result;
import com.dongruan.service.GridProvinceService;
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
@Api(tags = "管理员端省信息相关接口")
@Slf4j
public class AdminGridProvinceController {
    @Autowired
    private GridProvinceService gridProvinceService;

    /**
     * 查询所有省
     * @return
     */
    @GetMapping("/gridProvince/listGridProvinceAll")
    @ApiOperation("查询所有省")
    public Result<List<GridProvince>> listGridProvinceAll(){
        List<GridProvince> list = gridProvinceService.listGridProvinceAll();
        return Result.success(list);
    }
}
