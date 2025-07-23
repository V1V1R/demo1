package com.dongruan.mapper;

import com.dongruan.DTO.StatisticsPageRequestDTO;
import com.dongruan.ENTITY.Statistics;
import com.dongruan.VO.AqiDistributeTotalStatisVO;
import com.dongruan.VO.AqiTrendTotalStatisVO;
import com.dongruan.VO.ProvinceItemTotalStatisVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminStatisticsMapper {
    /**
     * 查询确认AQI信息列表
     * @param statisticsPageRequestDto
     * @return
     */
    Page<Statistics> listAqiFeedbackPage(StatisticsPageRequestDTO statisticsPageRequestDto);

    /**
     * 根据主键查询确认AQI信息
     * @param statistics
     * @return
     */
    @Select("select * from statistics where id = #{id}")
    Statistics getStatisticsById(Statistics statistics);

    /**
     * 查询省分组AQI超标累计信息
     * @return
     */
    List<ProvinceItemTotalStatisVO> listProvinceItemTotalStatis();

    /**
     * 查询以AQI等级为分 组的AQI分布统计信息
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
    @Select("select count(*) from statistics where confirm_date is not null and confirm_time is not null and gm_id is not null")
    Long getAqiCount();

    /**
     * 查询确认AQI良好数据数量
     * @return
     */
    @Select("select count(*) from  statistics where  aqi_id <= 2  and confirm_date is not null and confirm_time is not null and gm_id is not null")
    Long getAqiGoodCount();

    /**
     * 查询省网格的全国覆盖数
     * @return
     */
    @Select("select count(distinct province_id) from statistics where gm_id != 24  ;")
    Long getProvinceCoverage();

    /**
     * 查询市网格的全国覆盖数
     * @return
     */
    @Select("select count(distinct city_id) from statistics where gm_id != 24  ;")
    Long getCityCoverage();
}
