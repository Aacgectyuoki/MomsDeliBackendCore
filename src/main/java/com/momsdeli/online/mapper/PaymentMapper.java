package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.PaymentDTO;
import com.momsdeli.online.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO paymentToPaymentDTO(Payment payment);

    Payment paymentDTOToPayment(PaymentDTO paymentDTO);

    void updatePaymentFromDTO(PaymentDTO dto, @MappingTarget Payment entity);
}
