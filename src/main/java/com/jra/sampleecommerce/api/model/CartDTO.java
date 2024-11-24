package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Schema(name = "CartDTO", description = "Shopping Cart of the user")
public class CartDTO extends RepresentationModel<CartDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("items")
    @Valid
    private List<ItemDTO> items = null;

    public CartDTO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Cart Identifier
     *
     * @return id
     */

    @Schema(name = "id", description = "Cart Identifier", required = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CartDTO customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Id of the customer who possesses the cart
     *
     * @return customerId
     */

    @Schema(name = "customerId", description = "Id of the customer who possesses the cart", required = false)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CartDTO items(List<ItemDTO> items) {
        this.items = items;
        return this;
    }

    public CartDTO addItemsItem(ItemDTO itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * Collection of items in cart.
     *
     * @return items
     */
    @Valid
    @Schema(name = "items", description = "Collection of items in cart.", required = false)
    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartDTO cartDTO = (CartDTO) o;
        return Objects.equals(this.id, cartDTO.id) &&
                Objects.equals(this.customerId, cartDTO.customerId) &&
                Objects.equals(this.items, cartDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CartDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

