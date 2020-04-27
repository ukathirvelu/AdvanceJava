package com.sarves.cloud.load.service.impl;

import com.sarves.cloud.load.domain.Load;
import com.sarves.cloud.load.model.CarrierDTO;
import com.sarves.cloud.load.model.CommodityDTO;
import com.sarves.cloud.load.model.CustomerDTO;
import com.sarves.cloud.load.model.LoadDTO;
import com.sarves.cloud.load.repository.LoadRepository;
import com.sarves.cloud.load.service.LoadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    LoadRepository loadRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerService customerService;

    @Autowired
    CarrierService carrierService;




    @Override
    public List<LoadDTO> findAll() {
        List<Load> loads = loadRepository.findAll();
        List<LoadDTO> loadDTOS =  loads.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        for(LoadDTO loadDto : loadDTOS) {
            loadDto = customerService.attachCustomer(loadDto);
        }
        for(LoadDTO loadDto : loadDTOS) {

            loadDto = carrierService.attachCarrier(loadDto);
        }
        return loadDTOS;
    }






    @Override
    public LoadDTO findById(Long id) {
        Optional<Load> load = loadRepository.findById(id);
        if(load.isPresent()) {

            LoadDTO loadDto = this.convertToDto(load.get());
            loadDto = customerService.attachCustomer(loadDto);
            loadDto = carrierService.attachCarrier(loadDto);
            return loadDto;
        }
        return null;
    }

    private LoadDTO convertToDto(Load load) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        LoadDTO loadDTO = modelMapper.map(load, LoadDTO.class);
        if(load.getCustomerId()!= null) {
            loadDTO.setCustomerDTO( new CustomerDTO());
            loadDTO.getCustomerDTO().setId(load.getCustomerId());
        }
        if(load.getCarrierId()!= null) {
            loadDTO.setCarrierDTO( new CarrierDTO());
            loadDTO.getCarrierDTO().setId(load.getCarrierId());
        }
        return loadDTO;
    }
}
