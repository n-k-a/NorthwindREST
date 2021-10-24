package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.dto.EmployeeDTO;
import org.sparta.northwindrest.entities.EmployeeEntity;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService){
        this.employeeRepository= employeeRepository;
        this.employeeService = employeeService;
    }




    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeDTO> foundEmployee(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName){
        if (lastName!=null&& firstName!=null) {
            List<EmployeeDTO> foundEmployee= new ArrayList<>();
            for(EmployeeDTO employeeDTO : employeeService.getAllEmployees()){
                if(employeeDTO.getLastName().contains(lastName) && employeeDTO.getFirstName().contains(firstName)){
                    foundEmployee.add(employeeDTO);
                }
            }
            return foundEmployee;
        }
        else if (lastName!=null) {
            return employeeService.getAllEmployees()
                    .stream()
                    .filter((o) -> o.getLastName().contains(lastName))
                    .collect(Collectors.toList());
        }
        else if (firstName!=null){
        return employeeService.getAllEmployees()
                .stream()
                .filter((o) -> o.getFirstName().contains(firstName))
                .collect(Collectors.toList());}
        else
        {            return employeeService.getAllEmployees();
        }
    }
    @GetMapping ("/employees/{id}")
    public Optional<EmployeeEntity> getEmployeeByID(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }


}
