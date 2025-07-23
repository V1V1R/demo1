package com.dongruan.service;

import com.dongruan.DTO.GridMemberLoginDTO;
import com.dongruan.DTO.StatisticsDTO;
import com.dongruan.ENTITY.GridMember;

public interface GridMemberService {

/**
 * 网格员登录
 *
 * @param gridMemberLoginDTO 网格员登录参数
 * @return 网格员信息
 */
    GridMember login(GridMemberLoginDTO gridMemberLoginDTO);

/**
 * 保存网格员提交的AQI确认信息
 *
 * @param statisticsDTO 统计信息
 */
    void saveStatistics(StatisticsDTO statisticsDTO);
}
