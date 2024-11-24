package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.model.entity.Product;
import com.jra.sampleecommerce.repository.ProductRepository;
import com.jra.sampleecommerce.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<Product> getAllProducts() {
    return repository.findAll();
  }

  @Override
  public Optional<Product> getProduct(String id) {
    return repository
        .findById(UUID.fromString(id));
  }
}
