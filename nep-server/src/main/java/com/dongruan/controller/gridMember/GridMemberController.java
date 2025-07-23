package com.dongruan.controller.gridMember;

import com.dongruan.DTO.GridMemberLoginDTO;
import com.dongruan.DTO.StatisticsDTO;
import com.dongruan.ENTITY.GridMember;
import com.dongruan.VO.GridMemberLoginVO;
import com.dongruan.constant.JwtClaimsConstant;
import com.dongruan.jwtUtil.JwtUtil;
import com.dongruan.properties.JwtProperties;
import com.dongruan.result.Result;
import com.dongruan.service.GridMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gridMember")
@Api(tags = "网格员端相关接口")
@Slf4j
public class GridMemberController {
    @Autowired
    private GridMemberService gridMemberService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 网格员登录
     * @param gridMemberLoginDTO
     * @return
     */
    @PostMapping("/getGridMemberByCodeByPass")
    @ApiOperation("网格员登录")
    public Result<GridMemberLoginVO> login(@RequestBody GridMemberLoginDTO gridMemberLoginDTO) {
        log.info("网格员登录：{}",gridMemberLoginDTO);

        GridMember gridMember = gridMemberService.login(gridMemberLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.GM_ID, gridMember.getGmId());
        String token = JwtUtil.createJWT(
                jwtProperties.getGridMemberSecretKey(),
                jwtProperties.getGridMemberTtl(),
                claims);

        GridMemberLoginVO gridMemberLoginVO = GridMemberLoginVO.builder()
                  .gmCode(gridMember.getGmCode())
                  .token(token)
                  .build();

        return Result.success(gridMemberLoginVO);
    }

    /**
     * 保存网格员提交的AQI确认信息
     * @param statisticsDTO
     * @return
     */
    @PostMapping("/statistics/saveStatistics")
    @ApiOperation("保存网格员提交的AQI确认信息")
    public  Result saveStatistics (@RequestBody StatisticsDTO statisticsDTO){
             gridMemberService.saveStatistics(statisticsDTO);
             return Result.success();
    }


}
