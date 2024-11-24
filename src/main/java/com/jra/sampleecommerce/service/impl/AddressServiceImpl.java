package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.api.model.AddAddressReq;
import com.jra.sampleecommerce.model.entity.Address;
import com.jra.sampleecommerce.repository.AddressRepository;
import com.jra.sampleecommerce.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;

  public AddressServiceImpl(AddressRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Address> createAddress(AddAddressReq addAddressReq) {
    return Optional.of(repository.save(toEntity(addAddressReq)));
  }

  @Override
  public void deleteAddressesById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Optional<Address> getAddressesById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Iterable<Address> getAllAddresses() {
    return repository.findAll();
  }

  private Address toEntity(AddAddressReq model) {
    return Address.builder()
            .number(model.getNumber())
            .residency(model.getResidency())
            .street(model.getStreet())
            .city(model.getCity())
            .state(model.getState())
            .country(model.getCountry())
            .pincode(model.getPincode())
            .build();
  }
}
