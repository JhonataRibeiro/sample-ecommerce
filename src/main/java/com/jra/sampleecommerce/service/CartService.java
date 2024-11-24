package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.ItemDTO;
import com.jra.sampleecommerce.model.entity.Cart;
import jakarta.validation.Valid;

import java.util.List;

public interface CartService {

  List<ItemDTO> addCartItemsByCustomerId(String customerId, @Valid ItemDTO item);

  List<ItemDTO> addOrReplaceItemsByCustomerId(String customerId, @Valid ItemDTO item);

  void deleteCart(String customerId);

  void deleteItemFromCart(String customerId, String itemId);

  Cart getCartByCustomerId(String customerId);

  List<ItemDTO> getCartItemsByCustomerId(String customerId);

  ItemDTO getCartItemsByItemId(String customerId, String itemId);
}
