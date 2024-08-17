package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.RatingDTO;
import com.momsdeli.online.model.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RatingMapper {

    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);

    RatingDTO ratingToRatingDTO(Rating rating);

    Rating ratingDTOToRating(RatingDTO ratingDTO);

    void updateRatingFromDTO(RatingDTO dto, @MappingTarget Rating entity);
}
