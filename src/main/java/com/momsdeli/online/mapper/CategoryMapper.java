package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CategoryDTO;
import com.momsdeli.online.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    void updateCategoryFromDTO(CategoryDTO dto, @MappingTarget Category entity);
}
