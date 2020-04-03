package com.vi.spring.hateoas.resthateoas.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {

    @Id
    @GeneratedValue private Long id;
    private String name;
    private Long salary;
    private String role;

    public Users(String name, long salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }
}
