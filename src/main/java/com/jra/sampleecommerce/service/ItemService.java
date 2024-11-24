package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.ItemDTO;
import com.jra.sampleecommerce.model.entity.Item;

import java.util.List;

public interface ItemService {

    Item toEntity(ItemDTO itemDTO);

    List<Item> toEntityList(List<ItemDTO> items);

    ItemDTO toModel(Item e);

    List<ItemDTO> toModelList(List<Item> items);
}
