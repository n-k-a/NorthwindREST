package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;


    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /*
        @GetMapping ("/shippers")
        @ResponseBody
        public List<OrderEntity> foundOrder(@RequestParam(required = false) String name){
        }*/
    @GetMapping("/customers/{id}")
    public Optional<CustomerEntity> getCustomerByID(@PathVariable String id) {
        return customerRepository.findById(id);

    }
}