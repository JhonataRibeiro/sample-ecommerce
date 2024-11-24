package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.AddCardReq;
import com.jra.sampleecommerce.model.entity.Card;
import jakarta.validation.Valid;

import java.util.Optional;

public interface CardService {
  void deleteCardById(String id);
  Iterable<Card> getAllCards();
  Optional<Card> getCardById(String id);
  Optional<Card> registerCard(@Valid AddCardReq addCardReq);
}
