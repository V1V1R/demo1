package com.dongruan.mapper;

import com.dongruan.ENTITY.GridCity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GridCityMapper {

    /**
     * 查询所有市
     *
     * @return
     */
    @Select("select * from grid_city")
    List<GridCity> listGridCity();

}
