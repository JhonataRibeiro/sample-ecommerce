package com.jra.sampleecommerce.api;

import com.jra.sampleecommerce.api.model.RefreshToken;
import com.jra.sampleecommerce.api.model.SignInReq;
import com.jra.sampleecommerce.api.model.SignedInUser;
import com.jra.sampleecommerce.model.entity.User;
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
@Tag(name = "User", description = "Operations about signup, signin and so on")
public interface AuthApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/auth/token/refresh : Provides new JWT based on valid refresh token.
     * Provides new JWT based on valid refresh token.
     *
     * @param refreshToken  (optional)
     * @return For successful operation. (status code 200)
     */
    @Operation(
        operationId = "getAccessToken",
        summary = "Provides new JWT based on valid refresh token.",
        responses = {
            @ApiResponse(responseCode = "200", description = "For successful operation.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = SignedInUser.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = SignedInUser.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/auth/token/refresh",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<SignedInUser> getAccessToken(
        @Parameter(name = "RefreshToken", description = "") @Valid @RequestBody(required = false) RefreshToken refreshToken
    );


    /**
     * POST /api/v1/auth/token : Signin the customer (user)
     * Signin the customer (user) that generates the JWT (access token) and refresh token, which can be used for accessing APIs.
     *
     * @param signInReq  (optional)
     * @return For user sign-in. Once successful, user receives the access and refresh token. (status code 200)
     */
    @Operation(
        operationId = "signIn",
        summary = "Signin the customer (user)",
        responses = {
            @ApiResponse(responseCode = "200", description = "For user sign-in. Once successful, user receives the access and refresh token.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = SignedInUser.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = SignedInUser.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/auth/token",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<SignedInUser> signIn(
        @Parameter(name = "SignInReq", description = "") @Valid @RequestBody(required = false) SignInReq signInReq
    );


    /**
     * DELETE /api/v1/auth/token : Signouts the customer (user)
     * Signouts the customer (user). It removes the refresh token from DB. Last issued JWT should be removed from client end that if not removed last for given expiration time.
     *
     * @param refreshToken  (optional)
     * @return Accepts the request for logout. (status code 202)
     */
    @Operation(
        operationId = "signOut",
        summary = "Signouts the customer (user)",
        responses = {
            @ApiResponse(responseCode = "202", description = "Accepts the request for logout.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/auth/token",
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<Void> signOut(
        @Parameter(name = "RefreshToken", description = "") @Valid @RequestBody(required = false) RefreshToken refreshToken
    );


    /**
     * POST /api/v1/users : Signup the a new customer (user)
     * Creates a new customer (user), who can login and do the shopping.
     *
     * @param user  (optional)
     * @return For successful user creation. (status code 201)
     */
    @Operation(
        operationId = "signUp",
        summary = "Signup the a new customer (user)",
        responses = {
            @ApiResponse(responseCode = "201", description = "For successful user creation.", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = SignedInUser.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = SignedInUser.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/users",
        produces = { "application/xml", "application/json" },
        consumes = { "application/xml", "application/json" }
    )
    ResponseEntity<SignedInUser> signUp(
        @Parameter(name = "User", description = "") @Valid @RequestBody(required = false) User user
    );

}
