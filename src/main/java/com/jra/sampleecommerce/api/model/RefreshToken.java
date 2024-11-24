package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

/**
 * Contains the refresh token
 */

@Schema(name = "RefreshToken", description = "Contains the refresh token")
public class RefreshToken extends RepresentationModel<RefreshToken> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("refreshToken")
    private String refreshToken;

    public RefreshToken refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    @Schema(name = "refreshToken", description = "Refresh Token", required = false)
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefreshToken refreshToken = (RefreshToken) o;
        return Objects.equals(this.refreshToken, refreshToken.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefreshToken {\n");
        sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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

