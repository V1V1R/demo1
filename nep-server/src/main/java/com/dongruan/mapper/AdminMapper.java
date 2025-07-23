package com.dongruan.mapper;


import com.dongruan.DTO.AqiFeedbackPageRequestDto;
import com.dongruan.ENTITY.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from admins where admin_code = #{adminCode}")
    Admin getByAdminCode(String adminCode);

}
