package com.dongruan.service;

import com.dongruan.DTO.StatisticsPageRequestDTO;
import com.dongruan.ENTITY.Statistics;
import com.dongruan.VO.AqiDistributeTotalStatisVO;
import com.dongruan.VO.AqiTrendTotalStatisVO;
import com.dongruan.VO.ProvinceItemTotalStatisVO;
import com.dongruan.result.PageResult;

import java.util.List;

public interface AdminStatisticsService {
    /**
     * 查询确认AQI信息列表
     * @param statisticsPageRequestDto
     * @return
     */
    PageResult listStatisticsPage(StatisticsPageRequestDTO statisticsPageRequestDto);


    /**
     * 根据主键查询确认AQI信息
     * @param id
     * @return
     */
    Statistics getStatisticsById(Long id);


    /**
     * 查询省分组AQI超标累计信息
     * @return
     */
    List<ProvinceItemTotalStatisVO> listProvinceItemTotalStatis();


    /**
     * 查询以AQI等级为分组的AQI分布统计信息
     * @return
     */
    List<AqiDistributeTotalStatisVO> listAqiDistributeTotalStatis();


    /**
     * 查询当前12个月的AQI超标趋势统计信息
     * @return
     */
    List<AqiTrendTotalStatisVO> listAqiTrendTotalStatis();

    /**
     * 查询确认AQI数据数量
     * @return
     */
    Long getAqiCount();

    /**
     * 获取AQI良好数据数量
     * @return
     */
    Long getAqiGoodCount();

    /**
     * 查询省网格的全国覆盖数
     * @return
     */
    Long getProvinceCoverage();

    /**
     * 查询市网格的全国覆盖数
     * @return
     */
    Long getCityCoverage();
}
