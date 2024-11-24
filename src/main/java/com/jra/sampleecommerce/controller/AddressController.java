package com.jra.sampleecommerce.controller;

import com.jra.sampleecommerce.api.AddressApi;
import com.jra.sampleecommerce.api.model.AddAddressReq;
import com.jra.sampleecommerce.api.model.AddressDTO;
import com.jra.sampleecommerce.hateoas.AddressRepresentationModelAssembler;
import com.jra.sampleecommerce.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class AddressController implements AddressApi {

    private final AddressService service;

    private final AddressRepresentationModelAssembler assembler;

    public AddressController(AddressService addressService, AddressRepresentationModelAssembler assembler) {
        this.service = addressService;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<AddressDTO> createAddress(@Valid AddAddressReq addAddressReq) {
        return status(HttpStatus.CREATED).body(service.createAddress(addAddressReq).map(assembler::toModel).get());
    }

    @Override
    public ResponseEntity<Void> deleteAddressesById(String id) {
        service.deleteAddressesById(id);
        return accepted().build();
    }

    @Override
    public ResponseEntity<AddressDTO> getAddressesById(String id) {
        return service.getAddressesById(id).map(assembler::toModel)
                .map(ResponseEntity::ok).orElse(notFound().build());
    }

    @Override
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        return ok(assembler.toListModel(service.getAllAddresses()));
    }
}
