package com.jra.sampleecommerce.controller;

import com.jra.sampleecommerce.api.CartApi;
import com.jra.sampleecommerce.api.model.CartDTO;
import com.jra.sampleecommerce.api.model.ItemDTO;
import com.jra.sampleecommerce.hateoas.CartRepresentationModelAssembler;
import com.jra.sampleecommerce.service.CartService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CartsController implements CartApi {

    private static final Logger log = LoggerFactory.getLogger(CartsController.class);
    private final CartService service;
    private final CartRepresentationModelAssembler assembler;

    public CartsController(CartService service, CartRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> addCartItemsByCustomerId(String customerId, @Valid ItemDTO item) {
        log.info("Request for customer ID: {}\nItem: {}", customerId, item);
        return ok(service.addCartItemsByCustomerId(customerId, item));
    }

    @Override
    public ResponseEntity<List<ItemDTO>> addOrReplaceItemsByCustomerId(String customerId,
                                                                    @Valid ItemDTO item) {
        return ok(service.addOrReplaceItemsByCustomerId(customerId, item));
    }

    @Override
    public ResponseEntity<Void> deleteCart(String customerId) {
        service.deleteCart(customerId);
        return accepted().build();
    }

    @Override
    public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId) {
        service.deleteItemFromCart(customerId, itemId);
        return accepted().build();
    }

    @Override
    public ResponseEntity<CartDTO> getCartByCustomerId(String customerId) {
        return ok(assembler.toModel(service.getCartByCustomerId(customerId)));
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getCartItemsByCustomerId(String customerId) {
        return ok(service.getCartItemsByCustomerId(customerId));
    }

    @Override
    public ResponseEntity<ItemDTO> getCartItemsByItemId(String customerId, String itemId) {
        return ok(service.getCartItemsByItemId(customerId, itemId));
    }

}
