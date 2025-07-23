package com.dongruan.mapper;

import com.dongruan.ENTITY.GridProvince;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GridProvinceMapper {

    /**
     * 查询所有省信息
     *
     * @return
     */
    @Select("select * from grid_province")
    List<GridProvince> listGridProvinceAll();
}
