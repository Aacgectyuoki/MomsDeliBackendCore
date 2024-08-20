package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.ReviewDTO;
import com.momsdeli.online.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "user.username", target = "username")
    ReviewDTO toDTO(Review review);

    @Mapping(source = "productName", target = "product.name")
    @Mapping(source = "username", target = "user.username")
    Review toEntity(ReviewDTO reviewDTO);

    List<ReviewDTO> toDTOs(List<Review> reviews);

    List<Review> toEntities(List<ReviewDTO> reviewDTOs);
}
