package com.mygitgor.sofpos.application.service;

import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.domain.model.PaymentStatus;
import com.mygitgor.sofpos.domain.repository.PaymentRepository;
import com.mygitgor.sofpos.infrastructure.integration.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final Map<String, PaymentGateway> paymentGateways;

    @Transactional
    public Payment processPayment(Payment payment, String gatewayType) {
        PaymentGateway gateway = paymentGateways.get(gatewayType);

        if (gateway == null) {
            throw new IllegalArgumentException("Unknown payment gateway " + gatewayType);
        }

        PaymentStatus status = gateway.processPayment(payment);
        paymentRepository.updateStatus(payment.getId(), status);
        return payment;
    }
}