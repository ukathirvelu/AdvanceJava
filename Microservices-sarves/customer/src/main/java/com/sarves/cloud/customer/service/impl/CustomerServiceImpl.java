package com.sarves.cloud.customer.service.impl;

import com.sarves.cloud.customer.domain.Customer;
import com.sarves.cloud.customer.model.CustomerDTO;
import com.sarves.cloud.customer.repository.CustomerRepository;
import com.sarves.cloud.customer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return this.convertToDto(customer.get());
        }
        return null;

    }

    private CustomerDTO convertToDto(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return customerDTO;
    }
}
