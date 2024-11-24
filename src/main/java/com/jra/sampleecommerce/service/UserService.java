package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.RefreshToken;
import com.jra.sampleecommerce.api.model.SignedInUser;
import com.jra.sampleecommerce.api.model.UserDTO;
import com.jra.sampleecommerce.model.entity.Address;
import com.jra.sampleecommerce.model.entity.Card;
import com.jra.sampleecommerce.model.entity.User;

import java.util.Optional;

public interface UserService {
    void deleteCustomerById(String id);

    Optional<Iterable<Address>> getAddressesByCustomerId(String id);

    Iterable<User> getAllCustomers();

    Optional<Card> getCardByCustomerId(String id);

    Optional<User> getCustomerById(String id);

    Optional<SignedInUser> createUser(User user);

    User findUserByUsername(String username);

    SignedInUser getSignedInUser(User userEntity);

    Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);

    void removeRefreshToken(RefreshToken refreshToken);
}
