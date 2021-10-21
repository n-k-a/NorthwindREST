package org.sparta.northwindrest.repositories;

import org.sparta.northwindrest.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
}