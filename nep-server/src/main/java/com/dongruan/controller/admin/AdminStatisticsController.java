package com.dongruan.controller.admin;

import com.dongruan.DTO.StatisticsPageRequestDTO;
import com.dongruan.ENTITY.Statistics;
import com.dongruan.VO.AqiDistributeTotalStatisVO;
import com.dongruan.VO.AqiTrendTotalStatisVO;
import com.dongruan.VO.ProvinceItemTotalStatisVO;
import com.dongruan.result.PageResult;
import com.dongruan.result.Result;
import com.dongruan.service.AdminStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/statistics")
@Api(tags = "管理员端相关接口")
@Slf4j
public class AdminStatisticsController {

    @Autowired
    private AdminStatisticsService adminStatisticsService;

    /**
     * 查询确认AQI信息列表，并有模糊查询和分页功能
     * @param statisticsPageRequestDto
     * @return
     */
    @GetMapping("/listStatisticsPage")
    @ApiOperation("查询确认AQI信息列表")
    public Result<PageResult> listStatisticsPage(StatisticsPageRequestDTO statisticsPageRequestDto){

        PageResult pageResult = adminStatisticsService.listStatisticsPage(statisticsPageRequestDto);
        return Result.success(pageResult);

    }

    /**
     * 根据主键查询确认AQI信息
     * @param id
     * @return
     */
    @GetMapping("/getStatisticsById")
    @ApiOperation("根据主键查询确认AQI信息")
    public Result<Statistics> getStatisticsById(Long id){

        Statistics statistics = adminStatisticsService.getStatisticsById(id);
        return Result.success(statistics);

    }

    /**
     * 查询省分组AQI超标累计信息
     * @return
     */
    @GetMapping("/listProvinceItemTotalStatis")
    @ApiOperation("查询省分组AQI超标累计信息")
    public Result<List<ProvinceItemTotalStatisVO>> listProvinceItemTotalStatis(){

        List<ProvinceItemTotalStatisVO> list = adminStatisticsService.listProvinceItemTotalStatis();
        return Result.success(list);
    }

    /**
     * 查询以AQI等级为分组的AQI分布统计信息
     * @return
     */
    @GetMapping("/listAqiDistributeTotalStatis")
    @ApiOperation("查询以AQI等级为分组的AQI分布统计信息")
    public Result<List<AqiDistributeTotalStatisVO>> listAqiDistributeTotalStatis(){
        List<AqiDistributeTotalStatisVO> list = adminStatisticsService.listAqiDistributeTotalStatis();
        return Result.success(list);
    }

    /**
     * 查询当前12个月的AQI超标趋势统计信息
     * @return
     */
    @GetMapping("/listAqiTrendTotalStatis")
    @ApiOperation("查询当前12个月的AQI超标趋势统计信息")
    public  Result<List<AqiTrendTotalStatisVO>> listAqiTrendTotalStatis(){

        List<AqiTrendTotalStatisVO> list = adminStatisticsService.listAqiTrendTotalStatis();
        return Result.success(list);
    }

    /**
     * 查询确认AQI数据数量
     * @return
     */
    @GetMapping("/getAqiCount")
    @ApiOperation("查询确认AQI数据数量")
    public Result<Long> getAqiCount(){

        Long count = adminStatisticsService.getAqiCount();
        return Result.success(count);
    }

    /**
     * 确认AQI数据中AQI良好数据数量
     * @return
     */
    @GetMapping("/getAqiGoodCount")
    @ApiOperation("查询确认AQI良好数据数量")
    public Result<Long> getAqiGoodCount(){

        Long count = adminStatisticsService.getAqiGoodCount();
        return Result.success(count);
    }

    /**
     * 查询省网格的全国覆盖数
     * @return
     */
    @GetMapping("/getProvinceCoverage")
    @ApiOperation("查询省网格的全国覆盖数")
    public Result<Long> getProvinceCoverage(){

        Long coverage = adminStatisticsService.getProvinceCoverage();
        return Result.success(coverage);
    }

    /**
     * 获取市网格的全国覆盖数
     * @return
     */
    @GetMapping("/getCityCoverage")
    @ApiOperation("查询市网格的全国覆盖数")
    public Result<Long> getCityCoverage(){

        Long coverage = adminStatisticsService.getCityCoverage();
        return Result.success(coverage);
    }

}
