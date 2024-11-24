package com.jra.sampleecommerce.controller;

import com.jra.sampleecommerce.api.PaymentApi;
import com.jra.sampleecommerce.api.model.Authorization;
import com.jra.sampleecommerce.api.model.PaymentReq;
import com.jra.sampleecommerce.hateoas.PaymentRepresentationModelAssembler;
import com.jra.sampleecommerce.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController implements PaymentApi {

  private final PaymentService service;
  private final PaymentRepresentationModelAssembler assembler;

  public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Authorization> authorize(@Valid PaymentReq paymentReq) {
    return null;
  }

  @Override
  public ResponseEntity<Authorization> getOrdersPaymentAuthorization(
      @NotNull @Valid String id) {
    return null;
  }
}
