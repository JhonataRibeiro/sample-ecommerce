package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO extends RepresentationModel<AddressDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("residency")
    private String residency;

    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("pincode")
    private String pincode;

    public AddressDTO id(String id) {
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

    public AddressDTO number(String number) {
        this.number = number;
        return this;
    }

    /**
     * house of flat number
     *
     * @return number
     */

    @Schema(name = "number", description = "house of flat number", required = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AddressDTO residency(String residency) {
        this.residency = residency;
        return this;
    }

    /**
     * Socieity or building name
     *
     * @return residency
     */

    @Schema(name = "residency", description = "Socieity or building name", required = false)
    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public AddressDTO street(String street) {
        this.street = street;
        return this;
    }

    /**
     * street name
     *
     * @return street
     */

    @Schema(name = "street", description = "street name", required = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public AddressDTO city(String city) {
        this.city = city;
        return this;
    }

    /**
     * city name
     *
     * @return city
     */

    @Schema(name = "city", description = "city name", required = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressDTO state(String state) {
        this.state = state;
        return this;
    }

    /**
     * state name
     *
     * @return state
     */

    @Schema(name = "state", description = "state name", required = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AddressDTO country(String country) {
        this.country = country;
        return this;
    }

    /**
     * country name
     *
     * @return country
     */

    @Schema(name = "country", description = "country name", required = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressDTO pincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    /**
     * postal code
     *
     * @return pincode
     */

    @Schema(name = "pincode", description = "postal code", required = false)
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressDTO addressDTO = (AddressDTO) o;
        return Objects.equals(this.id, addressDTO.id) &&
                Objects.equals(this.number, addressDTO.number) &&
                Objects.equals(this.residency, addressDTO.residency) &&
                Objects.equals(this.street, addressDTO.street) &&
                Objects.equals(this.city, addressDTO.city) &&
                Objects.equals(this.state, addressDTO.state) &&
                Objects.equals(this.country, addressDTO.country) &&
                Objects.equals(this.pincode, addressDTO.pincode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, residency, street, city, state, country, pincode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddressDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    number: ").append(toIndentedString(number)).append("\n");
        sb.append("    residency: ").append(toIndentedString(residency)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
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

