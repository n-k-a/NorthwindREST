package org.sparta.mg.northwindrest.repositories;

import org.sparta.mg.northwindrest.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}