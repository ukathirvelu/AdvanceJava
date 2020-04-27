package com.sarves.cloud.customer.service;

import com.sarves.cloud.customer.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> findAll();
    public CustomerDTO findById(Long Id);
}
