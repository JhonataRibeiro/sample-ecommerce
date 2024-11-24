package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Authorization extends RepresentationModel<Authorization> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime time;

    @JsonProperty("authorized")
    private Boolean authorized;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;

    public Authorization orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Order Identification
     *
     * @return orderId
     */

    @Schema(name = "orderId", description = "Order Identification", required = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Authorization time(OffsetDateTime time) {
        this.time = time;
        return this;
    }

    /**
     * Timestamp when this authorization was created
     *
     * @return time
     */
    @Valid
    @Schema(name = "time", description = "Timestamp when this authorization was created", required = false)
    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public Authorization authorized(Boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    /**
     * Flat that specify whether the payment is authorized
     *
     * @return authorized
     */

    @Schema(name = "authorized", description = "Flat that specify whether the payment is authorized", required = false)
    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public Authorization message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Approavl or rejection message
     *
     * @return message
     */

    @Schema(name = "message", description = "Approavl or rejection message", required = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Authorization error(String error) {
        this.error = error;
        return this;
    }

    /**
     * Processing error description, if any
     *
     * @return error
     */

    @Schema(name = "error", description = "Processing error description, if any", required = false)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authorization authorization = (Authorization) o;
        return Objects.equals(this.orderId, authorization.orderId) &&
                Objects.equals(this.time, authorization.time) &&
                Objects.equals(this.authorized, authorization.authorized) &&
                Objects.equals(this.message, authorization.message) &&
                Objects.equals(this.error, authorization.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, time, authorized, message, error);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Authorization {\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

