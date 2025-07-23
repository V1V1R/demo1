package com.dongruan.DTO;

import lombok.Data;

@Data
public class StatisticsDTO {
    private Long id;

    private Integer provinceId;

    private Integer cityId;

    private String address;

    private Integer so2Value;

    private Integer so2Level;

    private Integer coValue;

    private Integer coLevel;

    private Integer spmValue;

    private Integer spmLevel;

    private Integer aqiId;

    private String telId;

    private String information;
}
