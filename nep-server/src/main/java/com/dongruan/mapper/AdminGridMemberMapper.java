package com.dongruan.mapper;

import com.dongruan.ENTITY.GridMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminGridMemberMapper {

    List<GridMember> list(GridMember gridMember);
}
