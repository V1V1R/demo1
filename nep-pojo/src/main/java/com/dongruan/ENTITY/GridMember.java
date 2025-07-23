package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GridMember {

    private  Long gmId;

    private String gmCode;

    private String password;

    private String gmName;

    private Integer provinceId;

    private Integer cityId;

    private String tel;

    private Integer status;

    private String remarks;

}
