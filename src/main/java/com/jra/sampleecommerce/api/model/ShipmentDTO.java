package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ShipmentDTO extends RepresentationModel<ShipmentDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("trackingNumber")
    private String trackingNumber;

    @JsonProperty("estDeliveryDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate estDeliveryDate;

    public ShipmentDTO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Shipment Identifier
     *
     * @return id
     */

    @Schema(name = "id", description = "Shipment Identifier", required = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShipmentDTO carrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    /**
     * Shipping Carrier
     *
     * @return carrier
     */

    @Schema(name = "carrier", description = "Shipping Carrier", required = false)
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public ShipmentDTO trackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    /**
     * Shipping Tracking Number
     *
     * @return trackingNumber
     */

    @Schema(name = "trackingNumber", description = "Shipping Tracking Number", required = false)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public ShipmentDTO estDeliveryDate(LocalDate estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
        return this;
    }

    /**
     * Estimated Delivery Date
     *
     * @return estDeliveryDate
     */
    @Valid
    @Schema(name = "estDeliveryDate", description = "Estimated Delivery Date", required = false)
    public LocalDate getEstDeliveryDate() {
        return estDeliveryDate;
    }

    public void setEstDeliveryDate(LocalDate estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShipmentDTO shipmentDTO = (ShipmentDTO) o;
        return Objects.equals(this.id, shipmentDTO.id) &&
                Objects.equals(this.carrier, shipmentDTO.carrier) &&
                Objects.equals(this.trackingNumber, shipmentDTO.trackingNumber) &&
                Objects.equals(this.estDeliveryDate, shipmentDTO.estDeliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carrier, trackingNumber, estDeliveryDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShipmentDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
        sb.append("    trackingNumber: ").append(toIndentedString(trackingNumber)).append("\n");
        sb.append("    estDeliveryDate: ").append(toIndentedString(estDeliveryDate)).append("\n");
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

