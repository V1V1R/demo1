package com.dongruan.service.Impl;

import com.dongruan.ENTITY.GridCity;
import com.dongruan.mapper.GridCityMapper;
import com.dongruan.service.GridCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GridCityServiceImpl implements GridCityService {
    @Autowired
    private GridCityMapper gridCityMapper;

    /**
     * 查询所有市
     *
     * @return
     */
    @Override
    public List<GridCity> listGridCity() {
        return gridCityMapper.listGridCity();
    }

}
