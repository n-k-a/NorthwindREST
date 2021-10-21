package org.sparta.northwindrest.repositories;

import org.sparta.northwindrest.entities.OrderDetailEntity;
import org.sparta.northwindrest.entities.OrderDetailEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailEntityId> {
}