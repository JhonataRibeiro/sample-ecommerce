package com.jra.sampleecommerce.hateoas;

import com.jra.sampleecommerce.api.model.CartDTO;
import com.jra.sampleecommerce.controller.CartsController;
import com.jra.sampleecommerce.model.entity.Cart;
import com.jra.sampleecommerce.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Component
public class CartRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Cart, CartDTO> {

  private final ItemService itemService;

  /**
   * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and
   * resource type.
   */
  public CartRepresentationModelAssembler(ItemService itemService) {
    super(CartsController.class, CartDTO.class);
    this.itemService = itemService;
  }

  /**
   * Coverts the Card entity to resource
   *
   * @param entity
   */
  @Override
  public CartDTO toModel(Cart entity) {
    String uid = Objects.nonNull(entity.getUser()) ? entity.getUser().getId().toString() : null;
    String cid = Objects.nonNull(entity.getId()) ? entity.getId().toString() : null;
    CartDTO resource = new CartDTO();
    BeanUtils.copyProperties(entity, resource);
    resource.id(cid).customerId(uid).items(itemService.toModelList(entity.getItems()));
      try {
          resource.add(linkTo(methodOn(CartsController.class).getCartByCustomerId(uid)).withSelfRel());
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      try {
          resource.add(linkTo(methodOn(CartsController.class).getCartItemsByCustomerId(uid))
              .withRel("cart-items"));
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      return resource;
  }

  /**
   * Coverts the collection of Product entities to list of resources.
   *
   * @param entities
   */
  public List<CartDTO> toListModel(Iterable<Cart> entities) {
    if (Objects.isNull(entities)) {
      return List.of();
    }
    return StreamSupport.stream(entities.spliterator(), false).map(this::toModel)
        .collect(toList());
  }

}
