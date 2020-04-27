package com.sarves.cloud.carrier.controller;

import com.sarves.cloud.carrier.model.CarrierDTO;
import com.sarves.cloud.carrier.service.CarrierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carriers")
public class CarrierController {

    @Autowired
    CarrierService carrierService;

    @GetMapping("")
    @ResponseBody
    public List<CarrierDTO> getAllCustomers() {
        return carrierService.getAllCarriers();
    }

    @GetMapping("/{id}")
    public CarrierDTO getCustomer(@PathVariable Long id) {
        return carrierService.getById(id);
    }
}

