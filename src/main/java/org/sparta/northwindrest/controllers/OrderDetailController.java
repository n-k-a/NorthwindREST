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
public class OrderDetailController {
    private OrderDetailRepository orderDetailRepository;


    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public OrderDetailController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }


    /*
        @GetMapping ("/shippers")
        @ResponseBody
        public List<OrderEntity> foundOrder(@RequestParam(required = false) String name){
        }*/
    /*@GetMapping("/order details/{id}")
    public Optional<OrderDetailEntity> getShipperByID(@PathVariable Integer id) {
        return orderDetailRepository.findById(id);


    }*/
}