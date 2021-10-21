package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}