package com.sarves.cloud.load.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sarves.cloud.load.model.CustomerDTO;
import com.sarves.cloud.load.model.LoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    public static String CUSTOMER_URL = "http://customer-rest/customers/";

    @HystrixCommand(groupKey="customers", fallbackMethod = "fallbackAttachCustomer",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    public LoadDTO attachCustomer(LoadDTO loadDto) {

        CustomerDTO customerDTO = restTemplate.getForObject(CUSTOMER_URL+loadDto.getCustomerDTO().getId(), CustomerDTO.class);
        loadDto.setCustomerDTO(customerDTO);
        return loadDto;

    }

    public LoadDTO fallbackAttachCustomer(LoadDTO loadDto) {

        System.out.println("Fall Back Method Called");
        CustomerDTO customerDTO = new CustomerDTO();
        loadDto.setCustomerDTO(customerDTO);
        return loadDto;

    }
}
