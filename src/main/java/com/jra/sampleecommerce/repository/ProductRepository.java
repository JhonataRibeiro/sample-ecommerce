package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}