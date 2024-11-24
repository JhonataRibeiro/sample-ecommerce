package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.api.model.NewOrder;
import com.jra.sampleecommerce.model.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt {

  @PersistenceContext private final EntityManager em;

  private final ItemRepository itemRepo;
  private final CartRepository cRepo;
  private final OrderItemRepository oiRepo;

  public OrderRepositoryImpl(
      EntityManager em, ItemRepository itemRepo, CartRepository cRepo, OrderItemRepository oiRepo) {
    this.em = em;
    this.itemRepo = itemRepo;
    this.cRepo = cRepo;
    this.oiRepo = oiRepo;
  }

  @Override
  public Optional<Order> insert(NewOrder m) {
    return Optional.empty();
  }

}
