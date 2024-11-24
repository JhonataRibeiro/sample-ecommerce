package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Shipment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShipmentRepository extends CrudRepository<Shipment, UUID> {
}