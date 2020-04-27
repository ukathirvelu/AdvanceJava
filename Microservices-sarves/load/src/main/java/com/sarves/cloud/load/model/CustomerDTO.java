package com.sarves.cloud.load.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
