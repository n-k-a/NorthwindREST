package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.entities.SupplierEntity;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SupplierController {
    private SupplierRepository supplierRepository;
    public SupplierController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @GetMapping ("/suppliers/{id}")
    public Optional<SupplierEntity> getSupplierByID(@PathVariable Integer id){
        return supplierRepository.findById(id);


    }


    @GetMapping ("/suppliers")
    @ResponseBody
    public List<SupplierEntity> foundSupplier(@RequestParam(required = false) String name){
        if(name ==null){
            return supplierRepository.findAll();
        }
        List<SupplierEntity> foundSupplier= new ArrayList<>();
        for(SupplierEntity supplierEntity : supplierRepository.findAll()){
            if(supplierEntity.getCompanyName().contains(name)){
                foundSupplier.add(supplierEntity);
            }
        }
        return foundSupplier;
    }

}
