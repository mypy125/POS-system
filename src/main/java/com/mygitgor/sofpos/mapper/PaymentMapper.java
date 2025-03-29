package com.mygitgor.sofpos.mapper;

import com.mygitgor.sofpos.domain.model.Payment;
import com.mygitgor.sofpos.infrastructure.database.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentEntity toEntity(Payment payment);
    Payment toDomain(PaymentEntity paymentEntity);
}