package com.sarves.cloud.carrier.service.impl;

import com.sarves.cloud.carrier.domain.Carrier;
import com.sarves.cloud.carrier.model.CarrierDTO;
import com.sarves.cloud.carrier.repository.CarrierRepository;
import com.sarves.cloud.carrier.service.CarrierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    CarrierRepository carrierRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CarrierDTO> getAllCarriers() {
        List<Carrier> customers = carrierRepository.findAll();
        return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarrierDTO getById(Long id) {
        Optional<Carrier> carrier = carrierRepository.findById(id);
        if(carrier.isPresent()) {
            return this.convertToDto(carrier.get());
        }
        return null;
    }

    private CarrierDTO convertToDto(Carrier carrier) {
        CarrierDTO carrierDTO = modelMapper.map(carrier, CarrierDTO.class);
        return carrierDTO;
    }
}
