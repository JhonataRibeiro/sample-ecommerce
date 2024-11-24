package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {
}