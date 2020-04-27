package com.sarves.cloud.load.controller;

import com.sarves.cloud.load.model.CustomerDTO;
import com.sarves.cloud.load.model.LoadDTO;
import com.sarves.cloud.load.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loads")
public class LoadController {

    @Autowired
    LoadService loadService;

    @GetMapping("")
    public List<LoadDTO> getAllLoads() {
        return loadService.findAll();
    }

    @GetMapping("/{id}")
    public LoadDTO getCustomer(@PathVariable Long id) {
        return loadService.findById(id);
    }
}
