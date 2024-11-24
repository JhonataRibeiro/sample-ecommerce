package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
}