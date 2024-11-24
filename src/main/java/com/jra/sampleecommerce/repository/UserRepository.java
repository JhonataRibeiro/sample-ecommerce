package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

    @Query(
            value =
                    "select count(u.*) from ecommerce.\"user\" u where u.username = :username or u.email = :email",
            nativeQuery = true)
    Integer findByUsernameOrEmail(String username, String email);

}