package com.dongruan.service.Impl;

import com.dongruan.ENTITY.GridMember;
import com.dongruan.constant.StatusConstant;
import com.dongruan.mapper.AdminGridMemberMapper;
import com.dongruan.service.AdminGridMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminGridMemberServiceImpl implements AdminGridMemberService {

    @Autowired
    private AdminGridMemberMapper adminGridMemberMapper;

    /**
     * 根据省和市查询可工作状态的所属网格员信息列表
     *
     * @param provinceId
     * @return
     */
    @Override
    public List<GridMember> list(Integer provinceId) {
        GridMember gridMember = GridMember.builder()
                .provinceId(provinceId)
                .status(StatusConstant.ENABLE)
                .build();

        return adminGridMemberMapper.list(gridMember);
    }
}
