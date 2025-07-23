package com.dongruan.service.Impl;

import com.dongruan.DTO.StatisticsPageRequestDTO;
import com.dongruan.ENTITY.Statistics;
import com.dongruan.VO.AqiDistributeTotalStatisVO;
import com.dongruan.VO.AqiTrendTotalStatisVO;
import com.dongruan.VO.ProvinceItemTotalStatisVO;
import com.dongruan.mapper.AdminStatisticsMapper;
import com.dongruan.result.PageResult;
import com.dongruan.service.AdminStatisticsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminStatisticsServiceImpl implements AdminStatisticsService {
    @Autowired
    private AdminStatisticsMapper adminStatisticsMapper;

    /**
     * 查询确认AQI信息列表
     *
     * @param statisticsPageRequestDto
     * @return
     */
    @Override
    public PageResult listStatisticsPage(StatisticsPageRequestDTO statisticsPageRequestDto) {


        PageHelper.startPage(statisticsPageRequestDto.getPage(),statisticsPageRequestDto.getPageSize());

        Page<Statistics> page = adminStatisticsMapper.listAqiFeedbackPage(statisticsPageRequestDto);
        long total = page.getTotal();
        List<Statistics> records = page.getResult();
        return new PageResult(total,records);


    }

    /**
     * 根据主键查询确认AQI信息
     *
     * @param id
     * @return
     */
    @Override
    public Statistics getStatisticsById(Long id) {
        Statistics statistics = Statistics.builder()
                .id(id)
                .build();

        statistics = adminStatisticsMapper.getStatisticsById(statistics);

        return statistics;
    }

    /**
     * 查询省分组AQI超标累计信息
     *
     * @return
     */
    @Override
    public List<ProvinceItemTotalStatisVO> listProvinceItemTotalStatis() {
        List<ProvinceItemTotalStatisVO> list = adminStatisticsMapper.listProvinceItemTotalStatis();
        return list;
    }

    /**
     * 查询以AQI等级为分组的AQI分布统计信息
     *
     * @return
     */
    @Override
    public List<AqiDistributeTotalStatisVO> listAqiDistributeTotalStatis() {
        List<AqiDistributeTotalStatisVO> list = adminStatisticsMapper.listAqiDistributeTotalStatis();
        return list;
    }

    /**
     * 查询当前12个月的AQI超标趋势统计信息
     *
     * @return
     */
    @Override
    public List<AqiTrendTotalStatisVO> listAqiTrendTotalStatis() {
        List<AqiTrendTotalStatisVO> list = adminStatisticsMapper.listAqiTrendTotalStatis();
        return list;
    }

    /**
     * 查询确认AQI数据数量
     *
     * @return
     */
    @Override
    public Long getAqiCount() {
        Long count = adminStatisticsMapper.getAqiCount();
        return count;
    }

    /**
     * 获取AQI良好数据数量
     *
     * @return
     */
    @Override
    public Long getAqiGoodCount() {
        Long count = adminStatisticsMapper.getAqiGoodCount();
        return count;
    }


    /**
     * 获取省网格的全国覆盖数
     *
     * @return
     */
    @Override
    public Long getProvinceCoverage() {
        Long coverage = adminStatisticsMapper.getProvinceCoverage();
        return coverage;
    }


    /**
     * 获取市网格的全国覆盖数
     *
     * @return
     */
    @Override
    public Long getCityCoverage() {
        Long coverage = adminStatisticsMapper.getCityCoverage();
        return coverage;
    }
}
