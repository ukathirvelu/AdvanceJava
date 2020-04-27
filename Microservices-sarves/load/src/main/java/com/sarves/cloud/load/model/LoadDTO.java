package com.sarves.cloud.load.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class LoadDTO {


    private Long loadId;

    private String age;

    private Set<CommodityDTO> commodityDTO;

    private String origin;

    private String destination;

    private Date pickUpDate;

    private  Date deliveryDate;

    private CustomerDTO customerDTO;

    private CarrierDTO carrierDTO;

}
