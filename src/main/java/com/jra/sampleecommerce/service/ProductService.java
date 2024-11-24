package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.model.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface ProductService {
  @NotNull Iterable<Product> getAllProducts();
  Optional<Product> getProduct(@Min(value = 1L, message = "Invalid product ID.") String id);
}