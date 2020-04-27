package com.sarves.cloud.carrier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrierDTO {
    private Long id;

    private String carrierName;

    private String email;

    private String phone;
}
