package com.mygitgor.sofpos.infrastructure.integration;

import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.domain.model.PaymentStatus;

public interface PaymentGateway {
    PaymentStatus processPayment(Payment payment);
}
