package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.EmployeeEntity;
import org.sparta.northwindrest.entities.OrderEntity;
import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.entities.SupplierEntity;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController{
    private OrderRepository orderRepository;


    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }





    @GetMapping ("/orders")
    @ResponseBody
    public List<OrderEntity> foundOrder(@RequestParam(required = false) String name){
        if(name ==null){
            return orderRepository.findAll();
        }
        List<OrderEntity> foundOrder= new ArrayList<>();
        for(OrderEntity orderEntity : orderRepository.findAll()){
            if(orderEntity.getCustomerID().contains(name)){
                foundOrder.add(orderEntity);
            }
        }
        return foundOrder;
    }
    @GetMapping ("/orders/{id}")
    public Optional<OrderEntity> getOrderByID(@PathVariable Integer id){
        return orderRepository.findById(id);


    }
}