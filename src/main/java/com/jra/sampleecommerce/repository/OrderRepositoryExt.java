package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.api.model.NewOrder;
import com.jra.sampleecommerce.model.entity.Order;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<Order> insert(NewOrder m);
}
