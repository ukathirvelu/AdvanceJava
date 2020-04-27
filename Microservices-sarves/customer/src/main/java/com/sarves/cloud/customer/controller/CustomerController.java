package com.sarves.cloud.customer.controller;

import com.sarves.cloud.customer.domain.Customer;
import com.sarves.cloud.customer.model.CustomerDTO;
import com.sarves.cloud.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    @ResponseBody
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }


}
