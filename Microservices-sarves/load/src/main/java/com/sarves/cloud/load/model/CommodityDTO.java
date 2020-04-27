package com.sarves.cloud.load.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CommodityDTO {


    private Long commodityId;

    private String commodityName;

    private BigDecimal commodityWeight;

    private BigDecimal commodityLength;


}
