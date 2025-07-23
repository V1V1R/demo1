package com.dongruan.controller.admin;

import com.dongruan.ENTITY.GridMember;
import com.dongruan.result.Result;
import com.dongruan.service.AdminGridMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员端网格员相关接口")
@Slf4j
public class AdminGridMemberController {
    @Autowired
    private AdminGridMemberService adminGridMemberService;

    /**
     * 查询指定省下的所有网格员
     *
     * @param provinceId
     * @return
     */
    @GetMapping("/listGridMemberByProvinceId/{provinceId}" )
    @ApiOperation("查询指定省下的所有网格员")
    public Result<List<GridMember>> list(@PathVariable Integer provinceId) {
        List<GridMember> list = adminGridMemberService.list(provinceId);
        return Result.success(list);
    }

}
