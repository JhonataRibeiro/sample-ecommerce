package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class PaymentDTO extends RepresentationModel<PaymentDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("authorized")
    private Boolean authorized;

    @JsonProperty("message")
    private String message;

    public PaymentDTO id(String id) {
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

    public PaymentDTO authorized(Boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    /**
     * Flag that specified whether payment is authorized or not
     *
     * @return authorized
     */

    @Schema(name = "authorized", description = "Flag that specified whether payment is authorized or not", required = false)
    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public PaymentDTO message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Approval or rejection message
     *
     * @return message
     */

    @Schema(name = "message", description = "Approval or rejection message", required = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentDTO paymentDTO = (PaymentDTO) o;
        return Objects.equals(this.id, paymentDTO.id) &&
                Objects.equals(this.authorized, paymentDTO.authorized) &&
                Objects.equals(this.message, paymentDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorized, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

