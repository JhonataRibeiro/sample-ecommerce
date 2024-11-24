package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID>, OrderRepositoryExt {

    @Query("select o from Order o join o.user u where u.id = :customerId")
    Iterable<Order> findByCustomerId(@Param("customerId") UUID customerId);

}