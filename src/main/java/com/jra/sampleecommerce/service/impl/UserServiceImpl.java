package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.api.model.RefreshToken;
import com.jra.sampleecommerce.api.model.SignedInUser;
import com.jra.sampleecommerce.exception.GenericAlreadyExistsException;
import com.jra.sampleecommerce.exception.InvalidRefreshTokenException;
import com.jra.sampleecommerce.model.entity.Address;
import com.jra.sampleecommerce.model.entity.Card;
import com.jra.sampleecommerce.model.entity.User;
import com.jra.sampleecommerce.model.entity.UserToken;
import com.jra.sampleecommerce.repository.UserRepository;
import com.jra.sampleecommerce.repository.UserTokenRepository;
import com.jra.sampleecommerce.security.JwtManager;
import com.jra.sampleecommerce.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserTokenRepository userTokenRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtManager tokenManager;

    public UserServiceImpl(
            UserRepository repository,
            UserTokenRepository userTokenRepository,
            @Lazy PasswordEncoder bCryptPasswordEncoder,
            JwtManager tokenManager) {
        this.repository = repository;
        this.userTokenRepository = userTokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenManager = tokenManager;
    }

    @Override
    public void deleteCustomerById(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Optional<Iterable<Address>> getAddressesByCustomerId(String id) {
        return repository.findById(UUID.fromString(id)).map(User::getAddresses);
    }

    @Override
    public Iterable<User> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Card> getCardByCustomerId(String id) {
        return Optional.of(repository.findById(UUID.fromString(id)).map(User::getCards).get().get(0));
    }

    @Override
    public Optional<User> getCustomerById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public Optional<SignedInUser> createUser(User user) {
        Integer count = repository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (count > 0) {
            throw new GenericAlreadyExistsException("Use different username and email.");
        }
        User User = repository.save(toEntity(user));
        return Optional.of(createSignedUserWithRefreshToken(User));
    }

    @Override
    @Transactional
    public SignedInUser getSignedInUser(User User) {
        userTokenRepository.deleteByUserId(User.getId());
        return createSignedUserWithRefreshToken(User);
    }

    private SignedInUser createSignedUserWithRefreshToken(User User) {
        return createSignedInUser(User).refreshToken(createRefreshToken(User));
    }

    private SignedInUser createSignedInUser(User User) {
        String token =
                tokenManager.create(
                        org.springframework.security.core.userdetails.User.builder()
                                .username(User.getUsername())
                                .password(User.getPassword())
                                .authorities(
                                        Objects.nonNull(User.getRole()) ? User.getRole().name() : "")
                                .build());
        return new SignedInUser()
                .username(User.getUsername())
                .accessToken(token)
                .userId(User.getId().toString());
    }

    @Override
    public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
        // You may add an additional validation for time that would remove/invalidate the refresh token
        return userTokenRepository
                .findByRefreshToken(refreshToken.getRefreshToken())
                .map(
                        ut ->
                                Optional.of(
                                        createSignedInUser(ut.getUser()).refreshToken(refreshToken.getRefreshToken())))
                .orElseThrow(() -> new InvalidRefreshTokenException("Invalid token."));
    }

    @Override
    public void removeRefreshToken(RefreshToken refreshToken) {
        userTokenRepository
                .findByRefreshToken(refreshToken.getRefreshToken())
                .ifPresentOrElse(
                        userTokenRepository::delete,
                        () -> {
                            throw new InvalidRefreshTokenException("Invalid token.");
                        });
    }

    @Override
    public User findUserByUsername(String username) {
        if (Strings.isBlank(username)) {
            throw new UsernameNotFoundException("Invalid user.");
        }

        final String uname = username.trim();

        return repository
                .findByUsername(uname)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Given user(%s) not found.", uname)));
    }

    private User toEntity(User user) {
        User User = new User();
        BeanUtils.copyProperties(user, User);
        User.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return User;
    }

    private String createRefreshToken(User user) {
        String token = RandomHolder.randomKey(128);
        userTokenRepository.save(new UserToken().setRefreshToken(token).setUser(user));
        return token;
    }

    // https://stackoverflow.com/a/31214709/109354
    // or can use org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(n)
    private static class RandomHolder {
        static final Random random = new SecureRandom();

        public static String randomKey(int length) {
            return String.format(
                            "%" + length + "s", new BigInteger(length * 5 /*base 32,2^5*/, random).toString(32))
                    .replace('\u0020', '0');
        }
    }

}
