package com.mygitgor.sofpos.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private UUID id;
    private String cardNumber;
    private BigDecimal amount;
    private String currency;
    private PaymentStatus status;
    private LocalDateTime createdAt;
    private CardType cardType;
}
