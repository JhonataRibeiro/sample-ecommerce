package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.Authorization;
import com.jra.sampleecommerce.api.model.ShippingReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
@Tag(name = "Shipping", description = "the Shipping API")
public interface ShippingApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/shipping : Ship the specified shipping request
     * Ship the specified shipping request
     *
     * @param shippingReq  (optional)
     * @return For successful post. (status code 201)
     */
    @Operation(
        operationId = "shipOrder",
        summary = "Ship the specified shipping request",
        responses = {
            @ApiResponse(responseCode = "201", description = "For successful post.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Authorization.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Authorization.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/shipping",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<Authorization> shipOrder(
        @Parameter(name = "ShippingReq", description = "") @Valid @RequestBody(required = false) ShippingReq shippingReq
    );

}
