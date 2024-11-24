package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Authorization;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorizationRepository extends CrudRepository<Authorization, UUID> {
}