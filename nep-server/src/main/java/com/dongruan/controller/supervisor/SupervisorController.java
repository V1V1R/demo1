package com.dongruan.controller.supervisor;


import com.dongruan.DTO.AqiFeedbackDTO;
import com.dongruan.DTO.SupervisorDTO;
import com.dongruan.DTO.SupervisorLoginDTO;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.ENTITY.Supervisor;
import com.dongruan.VO.SupervisorLoginVO;
import com.dongruan.constant.JwtClaimsConstant;
import com.dongruan.jwtUtil.JwtUtil;
import com.dongruan.properties.JwtProperties;
import com.dongruan.result.Result;
import com.dongruan.service.SupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/supervisor")
@Api(tags = "监督员端相关接口")
@Slf4j
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;
    @Autowired
    private JwtProperties jwtProperties;


    /**
     * 监督员登录
     *
     * @param supervisorLoginDTO
     * @return
     */
    @PostMapping("/getSupervisorByIdByPass")
    @ApiOperation("监督员登录")
    public Result<SupervisorLoginVO> login(@RequestBody SupervisorLoginDTO supervisorLoginDTO) {
        log.info("监督员登录：{}",supervisorLoginDTO);

        Supervisor supervisor = supervisorService.login(supervisorLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.SUP_TELD,supervisor.getTelId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSupervisorSecretKey(),
                jwtProperties.getSupervisorTtl(),
                claims);


        SupervisorLoginVO supervisorLoginVO = SupervisorLoginVO.builder()
                .telId(supervisor.getTelId())
                .realName(supervisor.getRealName())
                .token(token)
                .build();

        return Result.success(supervisorLoginVO);
    }


/**
     * 添加新监督员
     *
     * @param supervisorDTO
     * @return
     */
    @PostMapping("/saveSupervisor")
    @ApiOperation("监督员注册")
    public Result saveSupervisor(@RequestBody SupervisorDTO supervisorDTO) {
        log.info("new a supervisor: {}", supervisorDTO);
        supervisorService.saveSupervisor(supervisorDTO);
        return Result.success();

    }

    /**
     * 新增aqi反馈
     *
     * @param aqiFeedbackDTO
     * @return
     */
    @PostMapping("/aqiFeedback/saveAqiFeedback")
    @ApiOperation("新增aqi反馈")
    public Result saveAqiFeedback(@RequestBody AqiFeedbackDTO aqiFeedbackDTO) {
        log.info("new a aqiFeedback: {}", aqiFeedbackDTO);
        supervisorService.saveAqiFeedback(aqiFeedbackDTO);
        return Result.success();

    }


    /**
     * 根据监督员手机号查询aqi反馈
     *
     * @param telId
     * @return
     */
    @GetMapping("/{telId}")
    @ApiOperation("根据监督员手机号查询aqi反馈")
    public Result<AqiFeedback> listAqiFeedbackByTelId(@PathVariable String telId) {
        AqiFeedback aqiFeedback = supervisorService.listAqiFeedbackByTelId(telId);
        return Result.success(aqiFeedback);
    }

}
