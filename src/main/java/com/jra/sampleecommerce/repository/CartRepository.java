package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {

    @Query("select c from Cart c join c.user u where u.id = :customerId")
    Optional<Cart> findByCustomerId(@Param("customerId") UUID customerId);

}