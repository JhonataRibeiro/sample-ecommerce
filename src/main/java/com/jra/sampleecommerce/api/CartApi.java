
package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.CartDTO;
import com.jra.sampleecommerce.api.model.ItemDTO;
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
@Tag(name = "Cart", description = "Everything about cart")
public interface CartApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/carts/{customerId}/items : Adds an item in shopping cart
     * Adds an item to the shopping cart if it doesn&#39;t already exist, or increment quantity by the specified number of items if it does.
     *
     * @param customerId Customer Identifier (required)
     * @param itemDTO Item object (optional)
     * @return Item added successfully (status code 201)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "addCartItemsByCustomerId",
        summary = "Adds an item in shopping cart",
        responses = {
            @ApiResponse(responseCode = "201", description = "Item added successfully", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ItemDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ItemDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Given customer ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<List<ItemDTO>> addCartItemsByCustomerId(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
        @Parameter(name = "ItemDTO", description = "Item object") @Valid @RequestBody(required = false) ItemDTO itemDTO
    );


    /**
     * PUT /api/v1/carts/{customerId}/items : Replace/add an item in shopping cart
     * Adds an item to the shopping cart if it doesn&#39;t already exist, or replace with given item if it does.
     *
     * @param customerId Customer Identifier (required)
     * @param itemDTO Item object (optional)
     * @return Item added successfully (status code 201)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "addOrReplaceItemsByCustomerId",
        summary = "Replace/add an item in shopping cart",
        responses = {
            @ApiResponse(responseCode = "201", description = "Item added successfully", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ItemDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ItemDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Given customer ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<List<ItemDTO>> addOrReplaceItemsByCustomerId(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
        @Parameter(name = "ItemDTO", description = "Item object") @Valid @RequestBody(required = false) ItemDTO itemDTO
    );


    /**
     * DELETE /api/v1/carts/{customerId} : Delete the shopping cart
     * Deletes the shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 204)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "deleteCart",
        summary = "Delete the shopping cart",
        responses = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Given customer ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/carts/{customerId}"
    )
    ResponseEntity<Void> deleteCart(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId
    );


    /**
     * DELETE /api/v1/carts/{customerId}/items/{itemId} : Delete the item from shopping cart
     * Deletes the item from shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @param itemId Item (product) Identifier (required)
     * @return Accepts the request, regardless of whether the specified item exists in the cart or not. (status code 202)
     */
    @Operation(
        operationId = "deleteItemFromCart",
        summary = "Delete the item from shopping cart",
        responses = {
            @ApiResponse(responseCode = "202", description = "Accepts the request, regardless of whether the specified item exists in the cart or not.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/carts/{customerId}/items/{itemId}"
    )
    ResponseEntity<Void> deleteItemFromCart(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
        @Parameter(name = "itemId", description = "Item (product) Identifier", required = true) @PathVariable("itemId") String itemId
    );


    /**
     * GET /api/v1/carts/{customerId} : Returns the shopping cart
     * Returns the shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 200)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "getCartByCustomerId",
        summary = "Returns the shopping cart",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = CartDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = CartDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Given customer ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/carts/{customerId}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<CartDTO> getCartByCustomerId(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId
    );


    /**
     * GET /api/v1/carts/{customerId}/items : Returns the list of products in user&#39;s shopping cart
     * Returns the items in shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @return successful operation (status code 200)
     *         or Given customer ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "getCartItemsByCustomerId",
        summary = "Returns the list of products in user's shopping cart",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ItemDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ItemDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Given customer ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/carts/{customerId}/items",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<List<ItemDTO>> getCartItemsByCustomerId(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId
    );


    /**
     * GET /api/v1/carts/{customerId}/items/{itemId} : Returns given item from user&#39;s shopping cart
     * Returns given item from shopping cart of given customer
     *
     * @param customerId Customer Identifier (required)
     * @param itemId Item (product) Identifier (required)
     * @return If item exists in cart (status code 200)
     *         or Given item (product) ID doesn&#39;t exist (status code 404)
     */
    @Operation(
        operationId = "getCartItemsByItemId",
        summary = "Returns given item from user's shopping cart",
        responses = {
            @ApiResponse(responseCode = "200", description = "If item exists in cart", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ItemDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ItemDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Given item (product) ID doesn't exist")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/carts/{customerId}/items/{itemId}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<ItemDTO> getCartItemsByItemId(
        @Parameter(name = "customerId", description = "Customer Identifier", required = true) @PathVariable("customerId") String customerId,
        @Parameter(name = "itemId", description = "Item (product) Identifier", required = true) @PathVariable("itemId") String itemId
    );

}
