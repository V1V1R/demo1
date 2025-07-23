package com.dongruan.service;

import com.dongruan.ENTITY.GridMember;

import java.util.List;

public interface AdminGridMemberService {

    /**
     * 根据省和市查询可工作状态的所属网格员信息列表
     * @param provinceId
     * @return
     */
    List<GridMember> list(Integer provinceId);
}
