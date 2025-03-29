package com.mygitgor.sofpos.infrastructure.database;

import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.domain.model.PaymentStatus;
import com.mygitgor.sofpos.domain.repository.PaymentRepository;
import com.mygitgor.sofpos.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentMapper.toEntity(payment);
        return paymentMapper.toDomain(paymentJpaRepository.save(entity));
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentJpaRepository.findById(id)
                .map(paymentMapper::toDomain);
    }

    @Override
    @Transactional
    public void updateStatus(UUID id, PaymentStatus status) {
        paymentJpaRepository.updateStatus(id, status);
    }
}
