package com.dongruan.service.Impl;

import com.dongruan.ENTITY.Aqi;
import com.dongruan.mapper.AqiMapper;
import com.dongruan.service.AqiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AqiServiceImpl implements AqiService {
    @Autowired
    private AqiMapper aqiMapper;

    /**
     * 查询所有AQI
     *
     * @return
     */
    @Override
    public List<Aqi> listAqiAll() {
        return aqiMapper.listAqiAll();
    }

}
