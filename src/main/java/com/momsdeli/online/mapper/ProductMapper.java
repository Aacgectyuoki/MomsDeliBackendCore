package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.model.Product;
import com.momsdeli.online.request.ProductRequest;
import com.momsdeli.online.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategoryMapper.class, ReviewMapper.class, RatingMapper.class, DiscountMapper.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

//    @Mapping(source = "category.id", target = "categoryId")
//    @Mapping(source = "reviews", target = "reviews", qualifiedByName = "mapReviews")
//    @Mapping(source = "ratings", target = "ratings", qualifiedByName = "mapRatings")
//    @Mapping(source = "discounts", target = "discounts", qualifiedByName = "mapDiscounts")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    ProductDTO productToProductDTO(Product product);

//    @Mapping(source = "categoryId", target = "category.id")
//    @Mapping(source = "reviews", target = "reviews", qualifiedByName = "mapReviews")
//    @Mapping(source = "ratings", target = "ratings", qualifiedByName = "mapRatings")
//    @Mapping(source = "discounts", target = "discounts", qualifiedByName = "mapDiscounts")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product productDTOToProduct(ProductDTO productDTO);

    void updateProductFromDTO(ProductRequest dto, @MappingTarget Product entity);

    Product requestToProduct(ProductRequest request);

    ProductResponse productToResponse(Product product);
}
