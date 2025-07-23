package com.dongruan.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceItemTotalStatisVO {
    private Integer provinceId;

    private String provinceName;

    private String provinceAbbr;

    private Long so2Exceed;

    private Long coExceed;

    private Long spmExceed;

    private  Long aqiExceed;


}
