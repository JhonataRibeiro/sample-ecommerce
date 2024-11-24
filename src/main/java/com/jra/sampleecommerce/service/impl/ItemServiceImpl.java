package com.jra.sampleecommerce.service.impl;

import com.jra.sampleecommerce.api.model.ItemDTO;
import com.jra.sampleecommerce.model.entity.Item;
import com.jra.sampleecommerce.model.entity.Product;
import com.jra.sampleecommerce.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Item toEntity(ItemDTO itemDTO) {
        return Item.builder()
                .product(
                        Product.builder()
                                .id(UUID.fromString(itemDTO.getId()))
                                .build()
                )
                .price(itemDTO.getUnitPrice())
                .quantity(itemDTO.getQuantity())
                .build();
    }

    @Override
    public List<Item> toEntityList(List<ItemDTO> items) {
        if (Objects.isNull(items)) {
            return List.of();
        }
        return items.stream().map(this::toEntity).collect(toList());
    }

    @Override
    public ItemDTO toModel(Item e) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.id(e.getProduct().getId().toString()).unitPrice(e.getPrice()).quantity(e.getQuantity());
        return itemDTO;
    }

    @Override
    public List<ItemDTO> toModelList(List<Item> items) {
        if (Objects.isNull(items)) {
            return List.of();
        }
        return items.stream().map(this::toModel).collect(toList());
    }
}
