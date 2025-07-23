package com.dongruan.DTO;

import lombok.Data;

@Data
public class StatisticsPageRequestDTO {
    //页码
    private int page;

    //每页记录数
    private int pageSize;

    private String provinceName;

    private String cityName;
}
