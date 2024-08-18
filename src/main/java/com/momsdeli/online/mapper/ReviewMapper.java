package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ReviewDTO;
import com.momsdeli.online.model.Review;
import com.momsdeli.online.request.ReviewRequest;
import com.momsdeli.online.response.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {ProductMapper.class, RatingMapper.class, UserMapper.class})
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

//    @Mapping(target = "product.id", source = "product.id")
//    @Mapping(target = "user.id", source = "user.id")
//    @Mapping(target = "rating.id", source = "rating.id")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    ReviewDTO reviewToReviewDTO(Review review);

//    @Mapping(target = "product.id", source = "product.id")
//    @Mapping(target = "user.id", source = "user.id")
//    @Mapping(target = "rating.id", source = "rating.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Review reviewDTOToReview(ReviewDTO reviewDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateReviewFromDTO(ReviewRequest dto, @MappingTarget Review entity);

    Review requestToReview(ReviewRequest request);

    ReviewResponse reviewToResponse(Review review);
}
