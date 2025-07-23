package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GridProvince  {

    private Integer provinceId;


    private String provinceName;

    private String provinceAbbr;

    private String remarks;
}
