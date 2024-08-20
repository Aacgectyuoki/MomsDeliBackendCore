package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.PaymentDTO;
import com.momsdeli.online.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "order.id", target = "order")
    PaymentDTO toDTO(Payment payment);

    @Mapping(source = "order", target = "order.id")
    Payment toEntity(PaymentDTO paymentDTO);

    List<PaymentDTO> toDTOs(List<Payment> payments);

    List<Payment> toEntities(List<PaymentDTO> paymentDTOs);
}

