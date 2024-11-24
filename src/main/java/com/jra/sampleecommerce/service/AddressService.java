package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.AddAddressReq;
import com.jra.sampleecommerce.model.entity.Address;

import java.util.Optional;

public interface AddressService {
  Optional<Address> createAddress(AddAddressReq addAddressReq);

  void deleteAddressesById(String id);

  Optional<Address> getAddressesById(String id);

  Iterable<Address> getAllAddresses();
}
