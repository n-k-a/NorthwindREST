package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
}