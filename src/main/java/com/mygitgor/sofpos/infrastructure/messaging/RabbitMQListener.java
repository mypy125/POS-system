package com.mygitgor.sofpos.infrastructure.messaging;

import com.mygitgor.sofpos.application.service.PaymentService;
import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQListener {
    private final PaymentRepository paymentRepository;

    @RabbitListener(queues = "payment-status-queue")
    public void handlePaymentStatusUpdate(Payment payment) {
        log.info("Payment update received {}", payment);
        paymentRepository.updateStatus(payment.getId(), payment.getStatus());
    }
}
