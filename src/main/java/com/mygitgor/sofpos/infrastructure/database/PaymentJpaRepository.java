package com.mygitgor.sofpos.infrastructure.database;

import com.mygitgor.sofpos.domain.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
    @Modifying
    @Transactional
    @Query("UPDATE PaymentEntity p SET p.status = :status WHERE p.id = :id")
    void updateStatus(@Param("id") UUID id, @Param("status") PaymentStatus status);
}
