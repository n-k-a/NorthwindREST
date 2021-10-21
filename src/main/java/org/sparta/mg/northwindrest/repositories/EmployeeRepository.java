package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}