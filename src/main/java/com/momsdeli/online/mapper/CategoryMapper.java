package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CategoryDTO;
import com.momsdeli.online.model.Category;
import com.momsdeli.online.request.CategoryRequest;
import com.momsdeli.online.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class})
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

//    @Mapping(target = "products", source = "products", qualifiedByName = "mapProducts")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    CategoryDTO categoryToCategoryDTO(Category category);

//    @Mapping(target = "products", source = "products", qualifiedByName = "mapProducts")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateCategoryFromDTO(CategoryRequest dto, @MappingTarget Category entity);

    Category requestToCategory(CategoryRequest request);

    CategoryResponse categoryToResponse(Category category);
}