package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
import com.momsdeli.online.dto.PaymentMethodDTO;
import com.momsdeli.online.model.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethodDTO toDTO(PaymentMethod paymentMethod);

    PaymentMethod toEntity(PaymentMethodDTO paymentMethodDTO);

    List<PaymentMethodDTO> toDTOs(List<PaymentMethod> paymentMethods);
    List<PaymentMethod> toEntities(List<PaymentMethodDTO> paymentMethodDTOs);
}
