package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private ProductsRepository productsRepository;


    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public ProductController(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    /*
    * Change this to DTO
    * */
    @GetMapping("/products")
    @ResponseBody
    public List<ProductsEntity> foundProducts(@RequestParam(required = false) Integer supplierID,
                                              @RequestParam(required = false) Integer categoryID){
        if(supplierID !=null && categoryID !=null) {
            List<ProductsEntity> foundProducts= new ArrayList<>();
            for(ProductsEntity productsEntity : productsRepository.findAll()){
                if(productsEntity.getSupplierId()==supplierID &&productsEntity.getCategoryId() ==categoryID ){
                    foundProducts.add(productsEntity);
                }
            }
            return foundProducts;
        }
        else if(supplierID !=null){
            return productsRepository.findAll()
                    .stream()
                    .filter((o) -> o.getSupplierId().equals(supplierID))
                    .collect(Collectors.toList());
        }
        else if(categoryID !=null){
            return productsRepository.findAll()
                    .stream()
                    .filter((o) -> o.getCategoryId().equals(categoryID))
                    .collect(Collectors.toList());
        }

        else {
            return productsRepository.findAll();
        }
    }

    @GetMapping ("/products/{id}")
    public Optional<ProductsEntity> getProductsByID(@PathVariable Integer id){
        return productsRepository.findById(id);


    }



}
