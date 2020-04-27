package com.sarves.cloud.load.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name="commodity")
@Getter
@Setter
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commodityId;

    @Column(name="commodity_name")
    private String commodityName;

    @Column(name="commodity_weight")
    private Long commodityWeight;

    @Column(name="commodity_length")
    private Long commodityLength;

    @ManyToOne
    @JoinColumn(name = "load_id")
    private Load load;
}
