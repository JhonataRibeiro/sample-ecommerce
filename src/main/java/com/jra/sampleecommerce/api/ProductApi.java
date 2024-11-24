package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.ProductDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Product", description = "Operations about products")
public interface ProductApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/v1/products/{id} : Returns a product
     * Returns the product that matches the given product ID
     *
     * @param id Product Identifier (required)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "getProduct",
        summary = "Returns a product",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/products/{id}",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<ProductDTO> getProduct(
        @Parameter(name = "id", description = "Product Identifier", required = true) @PathVariable("id") String id
    );


    /**
     * GET /api/v1/products : Returns all the matched products
     * Returns the products that matches the given query criteria
     *
     * @param tag Product tag (optional)
     * @param name Product name (optional)
     * @param page Query page number (optional, default to 1)
     * @param size Query page size (optional, default to 10)
     * @return For successful fetch. (status code 200)
     */
    @Operation(
        operationId = "queryProducts",
        summary = "Returns all the matched products",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful fetch.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/products",
        produces = { "application/xml", "application/json" }
    )
    ResponseEntity<List<ProductDTO>> queryProducts(
        @Parameter(name = "tag", description = "Product tag") @Valid @RequestParam(value = "tag", required = false) String tag,
        @Parameter(name = "name", description = "Product name") @Valid @RequestParam(value = "name", required = false) String name,
        @Parameter(name = "page", description = "Query page number") @Valid @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
        @Parameter(name = "size", description = "Query page size") @Valid @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    );

}
