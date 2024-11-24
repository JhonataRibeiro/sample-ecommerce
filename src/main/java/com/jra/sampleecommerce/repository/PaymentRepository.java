package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<Payment, UUID> {
}