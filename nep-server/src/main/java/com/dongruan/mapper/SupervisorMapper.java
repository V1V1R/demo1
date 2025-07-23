package com.dongruan.mapper;

import com.dongruan.ENTITY.Supervisor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SupervisorMapper {

    /**
     * 根据手机号查询监督员信息
     *
     * @param telId
     * @return
     */
    @Select("select * from supervisor where tel_id = #{telId}")
    Supervisor getByTelId(String telId);

/**
 * 监督员注册
 *
 * @param supervisor
 */
    @Insert("insert into supervisor (tel_id,password,real_name,birthday,sex,remarks) values (#{telId},#{password},#{realName},#{birthday},#{sex},#{remarks})")
    void insert(Supervisor supervisor);
}
