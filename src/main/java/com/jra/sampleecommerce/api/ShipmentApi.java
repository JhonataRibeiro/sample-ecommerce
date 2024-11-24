package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.ShipmentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Shipment", description = "Operations about shippings")
public interface ShipmentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/v1/shipping/{id} : Return the Shipment
     * Return the Shipment for the specified order
     *
     * @param id Order Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "getShipmentByOrderId",
        summary = "Return the Shipment",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ShipmentDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ShipmentDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/shipping/{id}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<List<ShipmentDTO>> getShipmentByOrderId(
        @Parameter(name = "id", description = "Order Identifier", required = true) @PathVariable("id") String id
    );

}
