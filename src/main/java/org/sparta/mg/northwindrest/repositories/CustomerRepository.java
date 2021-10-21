package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}