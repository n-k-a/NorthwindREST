package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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

    @GetMapping (value = "/orders", params= {"OrderDate"})
    @ResponseBody
    public List<OrderEntity> getOrderbyD(@RequestParam(required = false) Instant oDate) {
        if (oDate==null){
            orderRepository.findAll();
        }
        List<OrderEntity> foundOrder = new ArrayList<>();
        for (OrderEntity orderEntity : orderRepository.findAll()) {
            if (orderEntity.getOrderDate()==(oDate)) {
                foundOrder.add(orderEntity);
            }
        }
        return foundOrder;
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
