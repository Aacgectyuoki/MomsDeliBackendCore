package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.PaymentDTO;
import com.momsdeli.online.model.Payment;
import com.momsdeli.online.request.PaymentRequest;
import com.momsdeli.online.response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderMapper.class})
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

//    @Mapping(target = "order.id", source = "order.id")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    PaymentDTO paymentToPaymentDTO(Payment payment);

//    @Mapping(target = "order.id", source = "order.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Payment paymentDTOToPayment(PaymentDTO paymentDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updatePaymentFromDTO(PaymentRequest dto, @MappingTarget Payment entity);

    Payment requestToPayment(PaymentRequest request);

    PaymentResponse paymentToResponse(Payment payment);
}
