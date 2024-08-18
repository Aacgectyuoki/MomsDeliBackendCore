package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.DiscountDTO;
import com.momsdeli.online.model.Discount;
import com.momsdeli.online.request.DiscountRequest;
import com.momsdeli.online.response.DiscountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

//    @Mapping(target = "product.id", source = "product.id")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    DiscountDTO discountToDiscountDTO(Discount discount);

//    @Mapping(target = "product.id", source = "product.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Discount discountDTOToDiscount(DiscountDTO discountDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateDiscountFromDTO(DiscountRequest request, @MappingTarget Discount entity);

    Discount requestToDiscount(DiscountRequest request);

    DiscountResponse discountToResponse(Discount discount);
}
