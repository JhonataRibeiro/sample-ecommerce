package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@Schema(name = "AddCardReq", description = "Request object for new card registration.")
public class AddCardReq extends RepresentationModel<AddCardReq> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("userId")
    private String userId;

    public AddCardReq id(String id) {
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

    public AddCardReq cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    /**
     * CardDTO Number
     *
     * @return cardNumber
     */

    @Schema(name = "cardNumber", description = "CardDTO Number", required = false)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public AddCardReq expires(String expires) {
        this.expires = expires;
        return this;
    }

    /**
     * Expiration date
     *
     * @return expires
     */

    @Schema(name = "expires", description = "Expiration date", required = false)
    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public AddCardReq cvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    /**
     * CVV code
     *
     * @return cvv
     */

    @Schema(name = "cvv", description = "CVV code", required = false)
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public AddCardReq userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     */

    @Schema(name = "userId", required = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddCardReq addCardReq = (AddCardReq) o;
        return Objects.equals(this.id, addCardReq.id) &&
                Objects.equals(this.cardNumber, addCardReq.cardNumber) &&
                Objects.equals(this.expires, addCardReq.expires) &&
                Objects.equals(this.cvv, addCardReq.cvv) &&
                Objects.equals(this.userId, addCardReq.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, expires, cvv, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddCardReq {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
        sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
        sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

