package org.sparta.northwindrest.services;

import org.sparta.northwindrest.dto.EmployeeDTO;
import org.sparta.northwindrest.dto.OrderDTO;
import org.sparta.northwindrest.dto.ProductNamesDTO;
import org.sparta.northwindrest.entities.OrderEntity;
import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.repositories.OrderRepository;
import org.sparta.northwindrest.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        return ((List<OrderEntity>) orderRepository
                .findAll())
                .stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToOrderDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setOrderDate(orderEntity.getOrderDate());
        orderDTO.setShippedDate(orderEntity.getShippedDate());
        orderDTO.setFreight(orderEntity.getFreight());
        orderDTO.setRequiredDate(orderEntity.getRequiredDate());
        orderDTO.setShipAddress(orderDTO.getShipAddress());
        orderDTO.setShipName(orderDTO.getShipName());
        orderDTO.setShipVia(orderDTO.getShipVia());
        orderDTO.setShipPostalCode(orderEntity.getShipPostalCode());
        orderDTO.setShipCountry(orderEntity.getShipCountry());
        orderDTO.setShipCity(orderEntity.getShipCity());
        orderDTO.setShipRegion(orderEntity.getShipRegion());
        orderDTO.setCustomerName(orderEntity.getCustomerID().getCompanyName());
        orderDTO.setEmployeeName(orderDTO.getEmployeeName());



        return orderDTO;
    }
    public Optional<OrderDTO> getById(Integer id) {
        return
                Optional.ofNullable(orderRepository.findAll().stream().map(this::convertToOrderDTO)
                        .filter(o -> id.equals(o.getId()))
                        .findAny()
                        .orElse(null));
    }


}
