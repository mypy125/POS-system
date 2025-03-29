package com.mygitgor.sofpos.config;

import com.mygitgor.sofpos.infrastructure.integration.PaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class PaymentGatewayConfig {

    @Bean
    public Map<String, PaymentGateway> paymentGatewaysMap(Map<String, PaymentGateway> gateways) {
        return gateways.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
