package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.Authorization;
import com.jra.sampleecommerce.api.model.PaymentReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
@Tag(name = "Payment", description = "Operations about payments")
public interface PaymentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/payments : Authorize a payment request
     * Authorize a payment request.
     *
     * @param paymentReq  (optional)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "authorize",
        summary = "Authorize a payment request",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Authorization.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Authorization.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/payments",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<Authorization> authorize(
        @Parameter(name = "PaymentReq", description = "") @Valid @RequestBody(required = false) PaymentReq paymentReq
    );


    /**
     * GET /api/v1/payments : Returns the payment authorization
     * Return the payment authorization for the specified order
     *
     * @param orderId Order Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "getOrdersPaymentAuthorization",
        summary = "Returns the payment authorization",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Authorization.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Authorization.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/payments",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<Authorization> getOrdersPaymentAuthorization(
        @NotNull @Parameter(name = "orderId", description = "Order Identifier", required = true) @Valid @RequestParam(value = "orderId", required = true) String orderId
    );

}
