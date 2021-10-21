package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.CategoryEntity;
import org.sparta.northwindrest.entities.OrderEntity;
import org.sparta.northwindrest.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryController {
    private CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<CategoryEntity> foundCategory(@RequestParam(required = false) String name){
        if(name ==null){
            return categoryRepository.findAll();
        }
        List<CategoryEntity> foundCategory= new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryRepository.findAll()){
            if(categoryEntity.getCategoryName().contains(name)){
                foundCategory.add(categoryEntity);
            }
        }
        return foundCategory;
    }
    @GetMapping ("/categories/{id}")
    public Optional<CategoryEntity> getCategoryByID(@PathVariable Integer id){
        return categoryRepository.findById(id);


    }
}
