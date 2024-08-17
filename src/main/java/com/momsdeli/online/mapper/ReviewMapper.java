package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ReviewDTO;
import com.momsdeli.online.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDTO reviewToReviewDTO(Review review);

    Review reviewDTOToReview(ReviewDTO reviewDTO);

    void updateReviewFromDTO(ReviewDTO dto, @MappingTarget Review entity);
}
