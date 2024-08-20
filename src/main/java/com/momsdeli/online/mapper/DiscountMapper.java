package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.DiscountDTO;
import com.momsdeli.online.model.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    @Mapping(source = "product.name", target = "productName")
    DiscountDTO toDTO(Discount discount);

    @Mapping(source = "productName", target = "product.name")
    Discount toEntity(DiscountDTO discountDTO);

    List<DiscountDTO> toDTOs(List<Discount> discounts);

    List<Discount> toEntities(List<DiscountDTO> discountDTOs);
}
