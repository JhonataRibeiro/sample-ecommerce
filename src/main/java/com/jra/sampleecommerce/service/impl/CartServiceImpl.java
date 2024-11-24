package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.api.model.ItemDTO;
import com.jra.sampleecommerce.exception.CustomerNotFoundException;
import com.jra.sampleecommerce.exception.GenericAlreadyExistsException;
import com.jra.sampleecommerce.exception.ItemNotFoundException;
import com.jra.sampleecommerce.model.entity.Cart;
import com.jra.sampleecommerce.model.entity.Item;
import com.jra.sampleecommerce.repository.CartRepository;
import com.jra.sampleecommerce.repository.UserRepository;
import com.jra.sampleecommerce.service.CartService;
import com.jra.sampleecommerce.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.toList;
import static org.springframework.objenesis.instantiator.util.UnsafeUtils.getUnsafe;

@Service
public class CartServiceImpl implements CartService {

  private final CartRepository repository;
  private final UserRepository userRepo;
  private final ItemService itemService;

  public CartServiceImpl(CartRepository repository, UserRepository userRepo,
                         ItemService itemService) {
    this.repository = repository;
    this.userRepo = userRepo;
    this.itemService = itemService;
  }

  @Override
  public List<ItemDTO> addCartItemsByCustomerId(String customerId, @Valid ItemDTO item) {
    Cart entity = getCartByCustomerId(customerId);

    long count = entity.getItems().stream()
        .filter(i -> i.getProduct().getId().equals(UUID.fromString(item.getId()))).count();

    if (count > 0) {
      throw new GenericAlreadyExistsException(
          String.format("Item with Id (%s) already exists. You can update it.", item.getId()));
    }
    entity.getItems().add(itemService.toEntity(item));
    return itemService.toModelList(repository.save(entity).getItems());
  }

  @Override
  public List<ItemDTO> addOrReplaceItemsByCustomerId(String customerId, @Valid ItemDTO item) {
    Cart cart = getCartByCustomerId(customerId);
    List<Item> items = Objects.nonNull(cart.getItems()) ? cart.getItems() : List.of();
    AtomicBoolean itemExists = new AtomicBoolean(false);
    items.forEach(i -> {
      if (i.getProduct().getId().equals(UUID.fromString(item.getId()))) {
        i.setQuantity(item.getQuantity());
        i.setPrice(i.getPrice());
        itemExists.set(true);
      }
    });
    if (!itemExists.get()) {
      items.add(itemService.toEntity(item));
    }
    return itemService.toModelList(repository.save(cart).getItems());
  }

  @Override
  public void deleteCart(String customerId) {
    // will throw the error if it doesn't exist
    Cart entity = getCartByCustomerId(customerId);
    repository.deleteById(entity.getId());
  }

  @Override
  public void deleteItemFromCart(String customerId, String itemId) {
    Cart entity = getCartByCustomerId(customerId);
    List<Item> updatedItems = entity.getItems().stream()
        .filter(i -> !i.getProduct().getId().equals(UUID.fromString(itemId))).collect(toList());
    entity.setItems(updatedItems);
    repository.save(entity);
  }

  @Override
  public Cart getCartByCustomerId(String customerId) {
    Cart entity = repository.findByCustomerId(UUID.fromString(customerId))
        .orElse(new Cart());
    if (Objects.isNull(entity.getUser())) {
      entity.setUser(userRepo.findById(UUID.fromString(customerId))
          .orElseThrow(() -> new CustomerNotFoundException(
              String.format(" - %s", customerId))));
    }
    return entity;
  }

  @Override
  public List<ItemDTO> getCartItemsByCustomerId(String customerId) {
    Cart entity = getCartByCustomerId(customerId);
    return itemService.toModelList(entity.getItems());
  }

  @Override
  public ItemDTO getCartItemsByItemId(String customerId, String itemId) {
    Cart entity = getCartByCustomerId(customerId);
    AtomicReference<Item> Item = new AtomicReference<>();
    entity.getItems().forEach(i -> {
      if (i.getProduct().getId().equals(UUID.fromString(itemId))) {
        Item.set(i);
      }
    });
    if (Objects.isNull(Item.get())) {
      getUnsafe().throwException(new ItemNotFoundException(String.format(" - %s", itemId)));
    }
    return itemService.toModel(Item.get());
  }
}
