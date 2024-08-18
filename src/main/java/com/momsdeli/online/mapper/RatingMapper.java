package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.RatingDTO;
import com.momsdeli.online.model.Rating;
import com.momsdeli.online.request.RatingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class, UserMapper.class})
public interface RatingMapper {

    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);

//    @Mapping(target = "product.id", source = "product.id")
//    @Mapping(target = "user.id", source = "user.id")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    RatingDTO ratingToRatingDTO(Rating rating);

//    @Mapping(target = "product.id", source = "product.id")
//    @Mapping(target = "user.id", source = "user.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Rating ratingDTOToRating(RatingDTO ratingDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateRatingFromDTO(RatingRequest dto, @MappingTarget Rating entity);

    Object ratingToResponse(Rating rating);

    Rating requestToRating(RatingRequest request);
}
