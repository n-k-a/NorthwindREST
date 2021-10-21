package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}