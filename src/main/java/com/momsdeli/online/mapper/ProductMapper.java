package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.name", target = "category")
    ProductDTO toDTO(Product product);

    @Mapping(source = "category", target = "category.name")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOs(List<Product> products);

    List<Product> toEntities(List<ProductDTO> productDTOs);

    // Method to update an existing Product entity from a ProductDTO
    @Mapping(source = "category", target = "category.name")
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}