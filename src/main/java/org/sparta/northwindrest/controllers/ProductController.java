package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.dto.ProductNamesDTO;
import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.ProductsRepository;
import org.sparta.northwindrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private ProductsRepository productsRepository;
    private ProductService productService;

    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public ProductController(ProductsRepository productsRepository, ProductService productService){
        this.productsRepository = productsRepository;
        this.productService = productService;
    }


   @GetMapping("/products")
    @ResponseBody
    public List<ProductNamesDTO> getProductsBySupplierAndCategory(
            @RequestParam(required = false) String supplier,
            @RequestParam(required = false) String category){
        if(supplier !=null && category !=null) {
            List<ProductNamesDTO> foundProducts= new ArrayList<>();
            for(ProductNamesDTO productNamesDTO : productService.getAllProductsCategoryAndSuppliers()){
                if(productNamesDTO.getSupplierName().contains(supplier) &&
                        productNamesDTO.getCategoryName().contains(category) ){
                    foundProducts.add(productNamesDTO);
                }
            }
            return foundProducts;
        }
        else if(supplier !=null){
            return productService.getAllProductsCategoryAndSuppliers()
                    .stream()
                    .filter((o) -> o.getSupplierName().contains(supplier))
                    .collect(Collectors.toList());
        }
        else if(category !=null){
            return productService.getAllProductsCategoryAndSuppliers()
                    .stream()
                    .filter((o) -> o.getCategoryName().contains(category))
                    .collect(Collectors.toList());
        }

        else {
            return productService.getAllProductsCategoryAndSuppliers();
        }
    }

    @GetMapping ("/products/{id}")
    public Optional<ProductNamesDTO> getProductsByID(@PathVariable Integer id){
       return Optional.ofNullable(productService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Not an ID in this db: " + id)));



    }



}
