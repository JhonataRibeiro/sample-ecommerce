package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.NewOrder;
import com.jra.sampleecommerce.model.entity.Order;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface OrderService {

    Optional<Order> addOrder(@Valid NewOrder newOrder);

    Iterable<com.jra.sampleecommerce.model.entity.Order> getOrdersByCustomerId(@NotNull @Valid String customerId);

    Optional<com.jra.sampleecommerce.model.entity.Order> getByOrderId(String id);
}
