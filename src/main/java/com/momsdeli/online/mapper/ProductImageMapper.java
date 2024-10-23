package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ProductImageDTO;
import com.momsdeli.online.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper for the entity {@link ProductImage} and its DTO {@link ProductImageDTO}.
 * Provides the conversion methods between entity and DTO.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    ProductImageDTO toDTO(ProductImage productImage);

    ProductImage toEntity(ProductImageDTO productImageDTO);

    List<ProductImageDTO> toDTOs(List<ProductImage> productImages);

    List<ProductImage> toEntities(List<ProductImageDTO> productImageDTOs);
}
