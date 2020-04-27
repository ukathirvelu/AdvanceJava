package com.sarves.cloud.load.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sarves.cloud.load.model.CarrierDTO;
import com.sarves.cloud.load.model.LoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarrierService {

    @Autowired
    RestTemplate restTemplate;

    public static String CARRIER_URL = "http://carrier-rest/carriers/";

    @HystrixCommand(groupKey = "carriers", fallbackMethod = "fallbackAttachCarrier",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            })
    public LoadDTO attachCarrier(LoadDTO loadDto) {

        CarrierDTO carrierDto = restTemplate.getForObject(CARRIER_URL+loadDto.getCarrierDTO().getId(), CarrierDTO.class);
        loadDto.setCarrierDTO(carrierDto);
        return loadDto;

    }

    public LoadDTO fallbackAttachCarrier(LoadDTO loadDto) {
        System.out.println("FallBack Method Called");
        CarrierDTO carrierDto = new CarrierDTO();
        loadDto.setCarrierDTO(carrierDto);
        return loadDto;

    }
}
