package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Schema(name = "NewOrder", description = "Contains the new order request information")
public class NewOrder extends RepresentationModel<NewOrder> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("address")
    private AddressDTO address;

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("items")
    @Valid
    private List<ItemDTO> items = null;

    public NewOrder customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     */

    @Schema(name = "customerId", required = false)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public NewOrder address(AddressDTO address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     */
    @Valid
    @Schema(name = "address", required = false)
    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public NewOrder card(CardDTO card) {
        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     */
    @Valid
    @Schema(name = "card", required = false)
    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public NewOrder items(List<ItemDTO> items) {
        this.items = items;
        return this;
    }

    public NewOrder addItemsItem(ItemDTO itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * Items in shopping cart
     *
     * @return items
     */
    @Valid
    @Schema(name = "items", description = "Items in shopping cart", required = false)
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
        NewOrder newOrder = (NewOrder) o;
        return Objects.equals(this.customerId, newOrder.customerId) &&
                Objects.equals(this.address, newOrder.address) &&
                Objects.equals(this.card, newOrder.card) &&
                Objects.equals(this.items, newOrder.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, address, card, items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewOrder {\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
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

