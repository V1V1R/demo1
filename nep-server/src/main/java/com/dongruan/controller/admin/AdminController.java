package com.dongruan.controller.admin;

import com.dongruan.DTO.*;
import com.dongruan.ENTITY.*;
import com.dongruan.VO.AdminLoginVO;

import com.dongruan.properties.JwtProperties;
import com.dongruan.service.AdminService;
import com.dongruan.constant.JwtClaimsConstant;
import com.dongruan.jwtUtil.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dongruan.result.Result;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员端相关接口")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 管理员登录
     * @param adminLoginDto
     * @return
     */
    @PostMapping("/getAdminsByCode")
    @ApiOperation("管理员登录")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDto) {
        log.info("管理员登录：{}", adminLoginDto);

        Admin admin = adminService.login(adminLoginDto);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ADM_ID, admin.getAdminId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);


          AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                  .adminCode(admin.getAdminCode())
                  .token(token)
                  .build();

        return Result.success(adminLoginVO);
    }


}
