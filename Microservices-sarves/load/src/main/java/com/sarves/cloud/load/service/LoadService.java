package com.sarves.cloud.load.service;

import com.sarves.cloud.load.model.LoadDTO;

import java.util.List;

public interface LoadService {

    public List<LoadDTO> findAll();
    public LoadDTO findById(Long Id);
}
