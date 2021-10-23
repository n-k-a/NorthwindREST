package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController{
    private OrderRepository orderRepository;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }



    @GetMapping ("/orders")
    @ResponseBody
    public List<OrderEntity> foundOrder(@RequestParam(required = false) String orderDate) {
        if (orderDate != null) {
            LocalDate localDateObj = LocalDate.parse(orderDate, dtf);

            List<OrderEntity> foundOrder = new ArrayList<>();
            for (OrderEntity orderEntity : orderRepository.findAll()) {

                LocalDate entityDate = LocalDateTime.ofInstant(orderEntity.getOrderDate(), ZoneId.systemDefault()).toLocalDate();
                entityDate = entityDate.minusDays(1);
                System.out.println(entityDate);
                System.out.println(localDateObj);
                if (entityDate.compareTo(localDateObj) == 0) {
                    foundOrder.add(orderEntity);
                }

            }
            return foundOrder;

        } else
        {
            return orderRepository.findAll();
    }
    }
    @GetMapping ("/orders/{id}")
    public Optional<OrderEntity> getOrderByID(@PathVariable Integer id){
        return orderRepository.findById(id);


    }
}
