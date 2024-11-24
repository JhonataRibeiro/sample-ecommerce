package com.jra.sampleecommerce.hateoas;

import com.jra.sampleecommerce.api.model.CardDTO;
import com.jra.sampleecommerce.controller.CardController;
import com.jra.sampleecommerce.model.entity.Card;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CardRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Card, CardDTO> {

  /**
   * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and
   * resource type.
   */
  public CardRepresentationModelAssembler() {
    super(CardController.class, CardDTO.class);
  }

  /**
   * Coverts the Card entity to resource
   * @param entity
   * @return
   */
  @Override
  public CardDTO toModel(Card entity) {
    String uid = Objects.nonNull(entity.getUser()) ? entity.getUser().getId().toString() : null;
    CardDTO resource = createModelWithId(entity.getId(), entity);
    BeanUtils.copyProperties(entity, resource);
    resource.id(entity.getId().toString()).cardNumber(entity.getNumber())
     .cvv(entity.getCvv()).expires(entity.getExpires()).userId(uid);
    // Self link generated by createModelWithId has missing api path. Therefore, generating additionally.
    // can be removed once fixed.
    resource.add(linkTo(methodOn(CardController.class).getCardById(entity.getId().toString())).withSelfRel());
    return resource;
  }

  /**
   * Coverts the collection of Product entities to list of resources.
   * @param entities
   * @return
   */
  public List<CardDTO> toListModel(Iterable<Card> entities) {
    if (Objects.isNull(entities)) return List.of();
    return StreamSupport.stream(entities.spliterator(), false).map(this::toModel).collect(toList());
  }

}
