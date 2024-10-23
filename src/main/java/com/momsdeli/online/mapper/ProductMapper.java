package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "category")
    ProductDTO toDTO(Product product);

    @Mapping(source = "category", target = "category.id")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOs(List<Product> products);

    List<Product> toEntities(List<ProductDTO> productDTOs);

    @Mapping(source = "category", target = "category.id")
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}
