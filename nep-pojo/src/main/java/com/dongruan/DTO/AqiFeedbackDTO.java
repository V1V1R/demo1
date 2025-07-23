package com.dongruan.DTO;

import lombok.Data;

@Data
public class AqiFeedbackDTO {
    private Long afId;

    private String telId;

    private Integer provinceId;

    private Integer cityId;

    private String address;

    private String information;

    private Integer estimatedGrade;



}
