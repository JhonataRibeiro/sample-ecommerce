package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, UUID> {
}