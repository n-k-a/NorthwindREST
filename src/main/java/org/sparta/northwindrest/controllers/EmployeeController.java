package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.EmployeeEntity;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }




    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeEntity> foundEmployee(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName){
        if (lastName!=null&& firstName!=null) {
            List<EmployeeEntity> foundEmployee= new ArrayList<>();
            for(EmployeeEntity employeeEntity : employeeRepository.findAll()){
                if(employeeEntity.getLastName().contains(lastName) && employeeEntity.getFirstName().contains(firstName)){
                    foundEmployee.add(employeeEntity);
                }
            }
            return foundEmployee;
        }
        else if (lastName!=null) {
            return employeeRepository.findAll()
                    .stream()
                    .filter((EmployeeEntity) -> EmployeeEntity.getLastName().contains(lastName))
                    .collect(Collectors.toList());
        }
        else if (firstName!=null){
        return employeeRepository.findAll()
                .stream()
                .filter((EmployeeEntity) -> EmployeeEntity.getFirstName().contains(firstName))
                .collect(Collectors.toList());}
        else
        {            return employeeRepository.findAll();
        }
    }
    @GetMapping ("/employees/{id}")
    public Optional<EmployeeEntity> getEmployeeByID(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }


}
