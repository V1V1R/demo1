package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aqi {
    private Long aqiId;

    private String chineseExplain;

    private  String aqiExplain;

    private String color;

    private String healthImpact;

    private String takeSteps;

    private Long so2Min;

    private Long so2Max;

    private Long co2Min;

    private Long co2Max;

    private Long spmMin;

    private Long spmMax;

    private String remarks;


}
