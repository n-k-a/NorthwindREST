package org.sparta.mg.northwindrest.controllers;

import org.sparta.mg.northwindrest.entities.CustomerEntity;
import org.sparta.mg.northwindrest.entities.EmployeeEntity;
import org.sparta.mg.northwindrest.entities.ProductsEntity;
import org.sparta.mg.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public NorthwindController(ProductsRepository productsRepository, EmployeeRepository employeeRespository){
        this.productsRepository = productsRepository;
        this.employeeRespository=employeeRespository;
    }

    @GetMapping ("/products")
    @ResponseBody
    public List<ProductsEntity> foundProducts(@RequestParam(required = false) String name){
        if(name ==null){
            return productsRepository.findAll();
        }
        List<ProductsEntity> foundProducts= new ArrayList<>();
        for(ProductsEntity productsEntity : productsRepository.findAll()){
            if(productsEntity.getProductName().contains(name)){
                foundProducts.add(productsEntity);
            }
        }
        return foundProducts;
    }
    @GetMapping ("/products/{id}")
    public Optional<ProductsEntity> getProductsByID(@PathVariable Integer id){
        return productsRepository.findById(id);


    }
    @GetMapping ("/employees")
    @ResponseBody
    public List<EmployeeEntity> foundEmployee(@RequestParam(required = false) String name){
        if(name ==null){
            return employeeRespository.findAll();
        }
        List<EmployeeEntity> foundEmployee= new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeRespository.findAll()){
            if(employeeEntity.getLastName().contains(name)){
                foundEmployee.add(employeeEntity);
            }
        }
        return foundEmployee;
    }
    @GetMapping ("/employees/{id}")
    public Optional<EmployeeEntity> getEmployeeByID(@PathVariable Integer id){
        return employeeRespository.findById(id);


    }
}
