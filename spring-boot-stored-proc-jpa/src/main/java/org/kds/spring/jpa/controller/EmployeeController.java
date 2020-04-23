package org.kds.spring.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.kds.spring.jpa.domain.Employees;
import org.kds.spring.jpa.domain.Load;
import org.kds.spring.jpa.domain.LoadDTO;
import org.kds.spring.jpa.repository.EmployeeRepository;
import org.kds.spring.jpa.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private LoadRepository loadRepository; 

   // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public List<Employees> getAllEmployees() {

        Iterable<Employees> employees = employeeRepository.getAllEmployees();

        List<Employees> target = new ArrayList<Employees>();
      //  employees.forEach(target::add);
        employees.forEach(emp -> {
        	target.add(emp);
        });
        return target;

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Employees> getAllEmployeeById(@PathVariable(name = "id") long id) {

        Employees one = employeeRepository.findOne(id);
        return new ResponseEntity<Employees>(one, HttpStatus.OK);
    }
    
    @GetMapping(value = "/load/{id}")
    public ResponseEntity<Load> getloadByLoadId(@PathVariable(name = "id") long id) {
 
    	Load one = (Load) loadRepository.findOne(id);
    	return new ResponseEntity <Load>(one, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getload/{id}")
    public LoadDTO getloadByNameQuery(@PathVariable(name = "id") long id) {
 
    	LoadDTO loadDto = loadRepository.getLoadById(id);
    	return loadDto;
    }
    


}
