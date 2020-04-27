package com.sarves.cloud.carrier.service;

import com.sarves.cloud.carrier.model.CarrierDTO;

import java.util.List;

public interface CarrierService {
    public List<CarrierDTO> getAllCarriers();
    public CarrierDTO getById(Long id);

}
