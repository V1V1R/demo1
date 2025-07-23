package com.dongruan.DTO;

import lombok.Data;

@Data
public class StatusUpdateDto {

    private Long afId;      // 反馈ID或统计ID


    private Integer state;   // 新状态值
}
