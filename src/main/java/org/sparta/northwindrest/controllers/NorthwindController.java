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
   /* @GetMapping ("value=/northwind/employees, params={title, city}")
    public List<EmployeeEntity> getEmployeeByTitleOrCity(
            @RequestParam String title,
            @RequestParam(required=false) String city){
        if(title !=null && city !=null){
            List<EmployeeEntity> foundEmployee= new ArrayList<>();
            for(EmployeeEntity employeeEntity : employeeRespository.findAll()){
                if(employeeEntity.getTitle().contains(title) && employeeEntity.getCity().contains(city)){
                    foundEmployee.add(employeeEntity);
                }
            }
            return foundEmployee;
        }
        else if (title != null && city ==null){
            return employeeRespository.findAll()
                    .stream()
                    .filter((employeeEntity) -> employeeEntity.getTitle().contains(title))
                    .collect(Collectors.toList());

        }
        else{
            return employeeRespository.findAll();
        }
    }
*/



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


    /*general methods with endpoints has it as resource/identifier/secondary resource or identifier
    * how far should I go? ID + Date? Product + ID + supplier ID?
    * */
}
