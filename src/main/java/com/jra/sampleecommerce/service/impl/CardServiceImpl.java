package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.api.model.AddCardReq;
import com.jra.sampleecommerce.model.entity.Card;
import com.jra.sampleecommerce.repository.CardRepository;
import com.jra.sampleecommerce.repository.UserRepository;
import com.jra.sampleecommerce.service.CardService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {
  private final CardRepository repository;
  private final UserRepository userRepo;

  public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
    this.repository = repository;
    this.userRepo = userRepo;
  }

  @Override
  public void deleteCardById(String id) {
    repository.deleteById(UUID.fromString(id));
  }

  @Override
  public Iterable<Card> getAllCards() {
    return repository.findAll();
  }

  @Override
  public Optional<Card> getCardById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Optional<Card> registerCard(@Valid AddCardReq addCardReq) {
    // add validation to make sure that only single card exists from one user
    // else it throws DataIntegrityViolationException for user_id (unique)
    return Optional.of(repository.save(toEntity(addCardReq)));
  }

  private Card toEntity(AddCardReq m) {
    Card.CardBuilder cardBuilder = Card.builder();

    userRepo.findById(UUID.fromString(m.getUserId())).ifPresent(cardBuilder::user);

    return cardBuilder
            .number(m.getCardNumber())
            .cvv(m.getCvv())
            .expires(m.getExpires())
            .build();

  }
}
