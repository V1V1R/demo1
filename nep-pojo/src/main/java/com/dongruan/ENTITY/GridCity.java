package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GridCity {


    private Integer cityId;


    private String cityName;


    private Integer provinceId;


    private String remarks;

}
