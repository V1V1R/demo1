package com.dongruan.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AqiTrendTotalStatisVO {
    private Long Id;

    private String date;

    private Integer aqiExceed;

}
