package org.sparta.northwindrest.services;

import org.sparta.northwindrest.dto.ProductNamesDTO;
import org.sparta.northwindrest.entities.CategoryEntity;
import org.sparta.northwindrest.entities.ProductsEntity;
import org.sparta.northwindrest.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductNamesDTO> getAllProductsCategoryAndSuppliers() {
        return ((List<ProductsEntity>) productsRepository
                .findAll())
                .stream()
                .map(this::convertToProductNamesDTO)
                .collect(Collectors.toList());
    }

    private ProductNamesDTO convertToProductNamesDTO(ProductsEntity productsEntity) {
        ProductNamesDTO productNamesDTO = new ProductNamesDTO();
        productNamesDTO.setProductID(productsEntity.getProductId());
        productNamesDTO.setProductName(productsEntity.getProductName());
        productNamesDTO.setCategoryName(productsEntity.getCategoryId().getCategoryName());
        productNamesDTO.setSupplierName(productsEntity.getSupplierId().getCompanyName());
        productNamesDTO.setQuantityPerUnit(productsEntity.getQuantityPerUnit());
        productNamesDTO.setUnitsInStock(productsEntity.getUnitsInStock());
        productNamesDTO.setUnitsOnOrder(productsEntity.getUnitsOnOrder());
        productNamesDTO.setReorderLevel(productsEntity.getReorderLevel());
        productNamesDTO.setDiscontinued(productsEntity.getDiscontinued());


        return productNamesDTO;
    }
}
