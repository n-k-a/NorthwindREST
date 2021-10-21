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
public class NorthwindController {
    private ProductsRepository productsRepository;
    private EmployeeRepository employeeRespository;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ShipperRepository shipperRepository;
    private SupplierRepository supplierRepository;
    private CategoryRepository categoryRepository;
    private OrderDetailRepository orderDetailRepository;


    /* Look up how auto wired work, just to see how a case switch
    * would work for this instead of instantiating everything*/

    @Autowired
    public NorthwindController(ProductsRepository productsRepository, EmployeeRepository employeeRespository,
                               OrderRepository orderRepository, SupplierRepository supplierRepository){
        this.productsRepository = productsRepository;
        this.employeeRespository=employeeRespository;
        this.orderRepository = orderRepository;
        this.supplierRepository = supplierRepository;
    }







    /*general methods with endpoints has it as resource/identifier/secondary resource or identifier
    * how far should I go? ID + Date? Product + ID + supplier ID?
    * */
}
