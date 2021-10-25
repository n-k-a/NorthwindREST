package org.sparta.northwindrest.controllers;

import org.hibernate.criterion.Order;
import org.sparta.northwindrest.dto.OrderDTO;
import org.sparta.northwindrest.entities.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController{
    private OrderRepository orderRepository;
    private OrderService orderService;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService){
        this.orderService = orderService;
        this.orderRepository = orderRepository;

    }



    @GetMapping ("/orders")
    @ResponseBody
    public List<OrderDTO> foundOrder(@RequestParam(required = false) String orderDate,
                                     @RequestParam(required = false) String shippedDate,
                                     @RequestParam(required = false) String requiredDate) {
        if (orderDate != null) {
            List<OrderDTO> foundOrder = new ArrayList<>();
            for (OrderDTO orderDTO : orderService.getAllOrders()) {
                if (compareDates(orderDate,orderDTO.getOrderDate()) == 0) {
                    foundOrder.add(orderDTO);
                }
            }
            return foundOrder;

        }
        else if (shippedDate!=null){
            List<OrderDTO> foundOrder = new ArrayList<>();
            for (OrderDTO orderDTO : orderService.getAllOrders()) {
                if (compareDates(shippedDate,orderDTO.getShippedDate()) == 0) {
                    foundOrder.add(orderDTO);
                }
            }
            return foundOrder;

        }
        else if (requiredDate!=null){
            List<OrderDTO> foundOrder = new ArrayList<>();
            for (OrderDTO orderDTO : orderService.getAllOrders()) {
                if (compareDates(requiredDate,orderDTO.getRequiredDate()) == 0) {
                    foundOrder.add(orderDTO);
                }
            }
            return foundOrder;

        }
        else
        {
            return orderService.getAllOrders();
    }
    }
    @GetMapping ("/orders/{id}")
    public Optional<OrderDTO> getOrderByID(@PathVariable Integer id){
        return Optional.ofNullable(orderService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Not an ID in this db: " + id)));

    }

    public int compareDates(String queryD, Instant compareD){
        LocalDate localDateObj;

        try {
            LocalDate entityDate = LocalDateTime.ofInstant(compareD, ZoneId.systemDefault()).toLocalDate();

            localDateObj= LocalDate.parse(queryD, dtf);
            entityDate = entityDate.minusDays(1);
            return entityDate.compareTo(localDateObj);

        }
        catch (DateTimeParseException e){
            throw new IllegalArgumentException("Inputted date does not fit the yyyy-MM-dd format");
        }

    }

}
