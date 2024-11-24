package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.AddAddressReq;
import com.jra.sampleecommerce.api.model.AddressDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Address", description = "Operations about user's address")
public interface AddressApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/addresses : Creates a new user addresses
     * Creates a new user addresses. Does nothing if address already exists.
     *
     * @param addAddressReq (optional)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
            operationId = "createAddress",
            summary = "Creates a new user addresses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = AddressDTO.class)),
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDTO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/addresses",
            produces = {"application/xml", "application/json"},
            consumes = {"application/xml", "application/json"}
    )
    ResponseEntity<AddressDTO> createAddress(
            @Parameter(name = "AddAddressReq", description = "") @Valid @RequestBody(required = false) AddAddressReq addAddressReq
    );


    /**
     * DELETE /api/v1/addresses/{id} : Deletes user&#39;s address
     * Deletes user&#39;s address based on given address ID.
     *
     * @param id address Identifier (required)
     * @return Accepts the deletion request and perform deletion. If ID does not exist, does nothing. (status code 202)
     */
    @Operation(
            operationId = "deleteAddressesById",
            summary = "Deletes user's address",
            responses = {
                    @ApiResponse(responseCode = "202", description = "Accepts the deletion request and perform deletion. If ID does not exist, does nothing.")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/v1/addresses/{id}"
    )
    ResponseEntity<Void> deleteAddressesById(
            @Parameter(name = "id", description = "address Identifier", required = true) @PathVariable("id") String id
    );


    /**
     * GET /api/v1/addresses/{id} : Returns user&#39;s address
     * Returns user&#39;s address based on given address ID.
     *
     * @param id address Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
            operationId = "getAddressesById",
            summary = "Returns user's address",
            responses = {
                    @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = AddressDTO.class)),
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDTO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/addresses/{id}",
            produces = {"application/xml", "application/json"}
    )
    ResponseEntity<AddressDTO> getAddressesById(
            @Parameter(name = "id", description = "address Identifier", required = true) @PathVariable("id") String id
    );


    /**
     * GET /api/v1/addresses : Returns all user&#39;s addresses
     * Returns all user&#39;s addresses, else empty collection
     *
     * @return For successful fetch. (status code 200)
     */
    @Operation(
            operationId = "getAllAddresses",
            summary = "Returns all user's addresses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = AddressDTO.class)),
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDTO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/addresses",
            produces = {"application/xml", "application/json"}
    )
    ResponseEntity<List<AddressDTO>> getAllAddresses(

    );

}
