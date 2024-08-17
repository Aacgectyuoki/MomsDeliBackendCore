package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);

    void updateProductFromDTO(ProductDTO dto, @MappingTarget Product entity);
}
