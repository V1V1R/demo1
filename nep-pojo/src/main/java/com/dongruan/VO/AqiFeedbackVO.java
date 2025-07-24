package com.dongruan.VO;

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
public class AqiFeedbackVO {


    private Long afId;


    private String telId;


    private Integer provinceId;

    private String provinceName;



    private Integer cityId;

    private String cityName;

    private String address;


    private String information;


    private Integer estimatedGrade;


    private LocalDate afDate;


    private LocalDateTime afTime;


    private Integer gmId;


    private LocalDate assignDate;


    private LocalDateTime assignTime;


    private Integer state; // 0=未派单,1=已派单,2=已确认


    private String remarks;
}
