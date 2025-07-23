package com.dongruan.mapper;

import com.dongruan.ENTITY.Aqi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AqiMapper {

    /**
     * 查询所有AQI
     *
     * @return
     */
    @Select("select * from aqi")
    List<Aqi> listAqiAll();
}
