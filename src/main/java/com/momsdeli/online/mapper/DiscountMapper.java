package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.DiscountDTO;
import com.momsdeli.online.model.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    DiscountDTO discountToDiscountDTO(Discount discount);

    Discount discountDTOToDiscount(DiscountDTO discountDTO);

    void updateDiscountFromDTO(DiscountDTO dto, @MappingTarget Discount entity);
}
