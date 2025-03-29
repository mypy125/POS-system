package com.mygitgor.sofpos.api.controller;

import com.mygitgor.sofpos.application.service.PaymentService;
import com.mygitgor.sofpos.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/{gateway}")
    public Payment processPayment(@PathVariable String gateway, @RequestBody Payment payment) {
        return paymentService.processPayment(payment, gateway);
    }
}