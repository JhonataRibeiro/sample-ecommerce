package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@Schema(name = "ShippingReq", description = "Contains information required for Shipping request")
public class ShippingReq extends RepresentationModel<ShippingReq> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("address")
    private AddressDTO address;

    @JsonProperty("itemCount")
    private Integer itemCount;

    public ShippingReq orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Order Identifier
     *
     * @return orderId
     */

    @Schema(name = "orderId", description = "Order Identifier", required = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ShippingReq address(AddressDTO address) {
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

    public ShippingReq itemCount(Integer itemCount) {
        this.itemCount = itemCount;
        return this;
    }

    /**
     * The number of items in the order
     *
     * @return itemCount
     */

    @Schema(name = "itemCount", description = "The number of items in the order", required = false)
    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShippingReq shippingReq = (ShippingReq) o;
        return Objects.equals(this.orderId, shippingReq.orderId) &&
                Objects.equals(this.address, shippingReq.address) &&
                Objects.equals(this.itemCount, shippingReq.itemCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, address, itemCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShippingReq {\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    itemCount: ").append(toIndentedString(itemCount)).append("\n");
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

