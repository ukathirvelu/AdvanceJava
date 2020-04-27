package com.sarves.cloud.load.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="load")
@Getter
@Setter
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loadId;

    private String age;

    @OneToMany(mappedBy = "load", fetch = FetchType.EAGER)
    private List<Commodity> commodity = new ArrayList<>();

    @Column(name="origin")
    private String origin;

    @Column(name="destination")
    private String destination;

    @Column(name="pickup_date")
    private Date pickUpDate;

    @Column(name="delivery_date")
    private  Date deliveryDate;


    @Column(name="customer_id")
    private Long customerId;

    @Column(name="carrier_id")
    private Long carrierId;

}
