package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Schema(name = "OrderDTO", description = "Represents an order")
public class OrderDTO extends RepresentationModel<OrderDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer")
    private UserDTO customer;

    @JsonProperty("address")
    private AddressDTO address;

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime date;

    @JsonProperty("items")
    @Valid
    private List<ItemDTO> items = null;

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("payment")
    private PaymentDTO payment;

    @JsonProperty("shipment")
    private ShipmentDTO shipment;

    /**
     * Order Status
     */
    public enum StatusEnum {
        CREATED("CREATED"),

        PAID("PAID"),

        SHIPPED("SHIPPED"),

        PAYMENT_FAILED("PAYMENT_FAILED"),

        SHIPMENT_FAILED("SHIPMENT_FAILED"),

        COMPLETED("COMPLETED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("status")
    private StatusEnum status;

    public OrderDTO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Order identifier
     *
     * @return id
     */

    @Schema(name = "id", description = "Order identifier", required = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderDTO customer(UserDTO customer) {
        this.customer = customer;
        return this;
    }

    /**
     * Get customer
     *
     * @return customer
     */
    @Valid
    @Schema(name = "customer", required = false)
    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }

    public OrderDTO address(AddressDTO address) {
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

    public OrderDTO card(CardDTO card) {
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

    public OrderDTO date(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Order's data and time details
     *
     * @return date
     */
    @Valid
    @Schema(name = "date", description = "Order's data and time details", required = false)
    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public OrderDTO items(List<ItemDTO> items) {
        this.items = items;
        return this;
    }

    public OrderDTO addItemsItem(ItemDTO itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * Collection of order items.
     *
     * @return items
     */
    @Valid
    @Schema(name = "items", description = "Collection of order items.", required = false)
    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public OrderDTO total(BigDecimal total) {
        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     */
    @Valid
    @Schema(name = "total", required = false)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderDTO payment(PaymentDTO payment) {
        this.payment = payment;
        return this;
    }

    /**
     * Get payment
     *
     * @return payment
     */
    @Valid
    @Schema(name = "payment", required = false)
    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public OrderDTO shipment(ShipmentDTO shipment) {
        this.shipment = shipment;
        return this;
    }

    /**
     * Get shipment
     *
     * @return shipment
     */
    @Valid
    @Schema(name = "shipment", required = false)
    public ShipmentDTO getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentDTO shipment) {
        this.shipment = shipment;
    }

    public OrderDTO status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Order Status
     *
     * @return status
     */

    @Schema(name = "status", description = "Order Status", required = false)
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(this.id, orderDTO.id) &&
                Objects.equals(this.customer, orderDTO.customer) &&
                Objects.equals(this.address, orderDTO.address) &&
                Objects.equals(this.card, orderDTO.card) &&
                Objects.equals(this.date, orderDTO.date) &&
                Objects.equals(this.items, orderDTO.items) &&
                Objects.equals(this.total, orderDTO.total) &&
                Objects.equals(this.payment, orderDTO.payment) &&
                Objects.equals(this.shipment, orderDTO.shipment) &&
                Objects.equals(this.status, orderDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, address, card, date, items, total, payment, shipment, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
        sb.append("    shipment: ").append(toIndentedString(shipment)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

