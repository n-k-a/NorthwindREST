package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.OrderDetailEntity;
import org.sparta.mg.northwindrest.entities.OrderDetailEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailEntityId> {
}