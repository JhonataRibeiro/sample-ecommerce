package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.AddCardReq;
import com.jra.sampleecommerce.api.model.CardDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
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
@Tag(name = "Card", description = "the Card API")
public interface CardApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /api/v1/cards/{id} : Deletes card&#39;s address
     * Deletes card&#39;s address based on given card ID.
     *
     * @param id card Identifier (required)
     * @return Accepts the deletion request and perform deletion. If ID does not exist, does nothing. (status code 202)
     */
    @Operation(
        operationId = "deleteCardById",
        summary = "Deletes card's address",
        responses = {
            @ApiResponse(responseCode = "202", description = "Accepts the deletion request and perform deletion. If ID does not exist, does nothing.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/cards/{id}"
    )
    ResponseEntity<Void> deleteCardById(
        @Parameter(name = "id", description = "card Identifier", required = true) @PathVariable("id") String id
    );


    /**
     * GET /api/v1/cards : Returns all user&#39;s cards
     * Returns all user&#39;s cards, else empty collection
     *
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "getAllCards",
        summary = "Returns all user's cards",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = CardDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = CardDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/cards",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<List<CardDTO>> getAllCards();


    /**
     * GET /api/v1/cards/{id} : Returns user&#39;s card
     * Returns user&#39;s card based on given card ID.
     *
     * @param id card Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "getCardById",
        summary = "Returns user's card",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = CardDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = CardDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/cards/{id}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<CardDTO> getCardById(
        @Parameter(name = "id", description = "card Identifier", required = true) @PathVariable("id") String id
    );


    /**
     * POST /api/v1/cards : Creates a new user addresses
     * Creates a new user addresses. Does nothing if address already exists.
     *
     * @param addCardReq  (optional)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "registerCard",
        summary = "Creates a new user addresses",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = CardDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = CardDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/cards",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<CardDTO> registerCard(
        @Parameter(name = "AddCardReq", description = "") @Valid @RequestBody(required = false) AddCardReq addCardReq
    );

}
