package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.UserToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserTokenRepository extends CrudRepository<UserToken, UUID> {

    Optional<UserToken> findByRefreshToken(String refreshToken);

    Optional<UserToken> deleteByUserId(UUID userId);

}