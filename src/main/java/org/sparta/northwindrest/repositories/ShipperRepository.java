package org.sparta.northwindrest.repositories;

import org.sparta.northwindrest.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}