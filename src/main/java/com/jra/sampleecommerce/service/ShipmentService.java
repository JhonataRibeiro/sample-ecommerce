package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.model.entity.Shipment;
import jakarta.validation.constraints.Min;

public interface ShipmentService {
  Iterable<Shipment> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
