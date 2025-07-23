package com.dongruan.service.Impl;

import com.dongruan.ENTITY.GridProvince;
import com.dongruan.mapper.GridProvinceMapper;
import com.dongruan.service.GridProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GridProvinceServiceImpl implements GridProvinceService {
    @Autowired
    private GridProvinceMapper gridProvinceMapper;

    /**
     * 查询所有省
     *
     * @return
     */
    @Override
    public List<GridProvince> listGridProvinceAll() {
        return gridProvinceMapper.listGridProvinceAll();
    }
}
