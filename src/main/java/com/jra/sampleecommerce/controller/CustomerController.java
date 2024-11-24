package com.jra.sampleecommerce.controller;

import com.jra.sampleecommerce.api.CustomerApi;
import com.jra.sampleecommerce.api.model.AddressDTO;
import com.jra.sampleecommerce.api.model.CardDTO;
import com.jra.sampleecommerce.api.model.UserDTO;
import com.jra.sampleecommerce.hateoas.AddressRepresentationModelAssembler;
import com.jra.sampleecommerce.hateoas.CardRepresentationModelAssembler;
import com.jra.sampleecommerce.hateoas.UserRepresentationModelAssembler;
import com.jra.sampleecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CustomerController implements CustomerApi {

  private final UserRepresentationModelAssembler assembler;
  private final AddressRepresentationModelAssembler addrAssembler;
  private final CardRepresentationModelAssembler cardAssembler;
  private final UserService service;

  public CustomerController(UserService service, UserRepresentationModelAssembler assembler,
                            AddressRepresentationModelAssembler addrAssembler,
                            CardRepresentationModelAssembler cardAssembler) {
    this.service = service;
    this.assembler = assembler;
    this.addrAssembler = addrAssembler;
    this.cardAssembler = cardAssembler;
  }

  @Override
  public ResponseEntity<Void> deleteCustomerById(String id) {
    service.deleteCustomerById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<List<AddressDTO>> getAddressesByCustomerId(String id) {
    return service.getAddressesByCustomerId(id).map(addrAssembler::toListModel)
        .map(ResponseEntity::ok).orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<UserDTO>> getAllCustomers() {
    return ok(assembler.toListModel(service.getAllCustomers()));
  }

  @Override
  public ResponseEntity<CardDTO> getCardByCustomerId(String id) {
    return service.getCardByCustomerId(id).map(cardAssembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }

  @Override
  public ResponseEntity<UserDTO> getCustomerById(String id) {
    return service.getCustomerById(id).map(assembler::toModel).map(ResponseEntity::ok)
        .orElse(notFound().build());
  }
}
