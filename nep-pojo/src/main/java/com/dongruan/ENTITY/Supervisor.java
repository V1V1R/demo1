package com.dongruan.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {

    private String telId; // 手机号


    private String password;


    private String realName;

    private String birthday;

    private Integer sex; // 1=男,0=女

    private String remarks;
}
