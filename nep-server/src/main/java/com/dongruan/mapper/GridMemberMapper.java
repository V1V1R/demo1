package com.dongruan.mapper;

import com.dongruan.ENTITY.GridMember;
import com.dongruan.ENTITY.Statistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GridMemberMapper {

    /**
     * 根据网格员编号查询网格员信息
     *
     * @param gmCode 网格员编号
     * @return 网格员信息
     */
    @Select("select * from grid_member where gm_code = #{gmCode}")
    GridMember getByGmCode(String gmCode);

    /**
     * 保存网格员提交的AQI确认信息
     *
     * @param statistics 统计信息
     */
    @Insert("insert into statistics(province_id, city_id, address, so2_value, so2_level, co_value, co_level, spm_value, spm_level, aqi_id, confirm_date, confirm_time, gm_id, fd_id, information)"
            +"values" +
            "(#{provinceId},#{cityId},#{address},#{so2Value},#{so2Level},#{coValue},#{coLevel},#{spmValue},#{spmLevel},#{aqiId},#{confirmDate},#{confirmTime},#{gmId},#{fdId},#{information})")
    void insert(Statistics statistics);
}
