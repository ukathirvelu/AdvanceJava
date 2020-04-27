package com.sarves.cloud.carrier.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carrier")
@Getter
@Setter
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carrierName;

    private String email;

    private String phone;
}
