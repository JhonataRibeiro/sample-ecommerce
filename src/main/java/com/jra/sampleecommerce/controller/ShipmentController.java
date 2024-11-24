package com.jra.sampleecommerce.controller;

import com.jra.sampleecommerce.api.ShipmentApi;
import com.jra.sampleecommerce.api.model.ShipmentDTO;
import com.jra.sampleecommerce.hateoas.ShipmentRepresentationModelAssembler;
import com.jra.sampleecommerce.service.ShipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController implements ShipmentApi {

  private final ShipmentService service;
  private final ShipmentRepresentationModelAssembler assembler;

  public ShipmentController(ShipmentService service, ShipmentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<List<ShipmentDTO>> getShipmentByOrderId(@NotNull @Valid String id) {
    return ResponseEntity.ok(assembler.toListModel(service.getShipmentByOrderId(id)));
  }
}
