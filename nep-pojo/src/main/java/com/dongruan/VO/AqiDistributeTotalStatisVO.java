package com.dongruan.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AqiDistributeTotalStatisVO {

    private Long aqiId;

    private String chineseExplain;

    private Long aqiDistribute;
}
