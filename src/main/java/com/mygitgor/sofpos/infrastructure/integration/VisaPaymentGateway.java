package com.mygitgor.sofpos.infrastructure.integration;

import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.domain.model.PaymentStatus;

public class VisaPaymentGateway implements PaymentGateway{
    @Override
    public PaymentStatus processPayment(Payment payment) {
        return null;
    }
}
