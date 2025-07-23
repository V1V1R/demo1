package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Long adminId;


    private String adminCode;


    private String password;


    private String remarks;
}
