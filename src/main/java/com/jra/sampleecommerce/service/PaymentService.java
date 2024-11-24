package com.jra.sampleecommerce.service;

import com.jra.sampleecommerce.api.model.PaymentReq;
import com.jra.sampleecommerce.model.entity.Authorization;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface PaymentService {

  Optional<Authorization> authorize(@Valid PaymentReq paymentReq);
  Optional<Authorization> getOrdersPaymentAuthorization(@NotNull String orderId);
}
