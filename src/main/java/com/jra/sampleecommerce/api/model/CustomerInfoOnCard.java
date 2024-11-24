package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@Schema(name = "CustomerInfoOnCard", description = "Customer information required for payment processing")
public class CustomerInfoOnCard extends RepresentationModel<CustomerInfoOnCard> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    public CustomerInfoOnCard firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Customer first name
     *
     * @return firstName
     */

    @Schema(name = "firstName", description = "Customer first name", required = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerInfoOnCard lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Customer last name
     *
     * @return lastName
     */

    @Schema(name = "lastName", description = "Customer last name", required = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerInfoOnCard customerInfoOnCard = (CustomerInfoOnCard) o;
        return Objects.equals(this.firstName, customerInfoOnCard.firstName) &&
                Objects.equals(this.lastName, customerInfoOnCard.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerInfoOnCard {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

