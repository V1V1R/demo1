package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

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

    private LocalDate confirmDate;

    private LocalDateTime confirmTime;


    private Long gmId;

    private String fdId; // 公众监督员电话


    private String information;


    private String remarks;
}