package com.momsdeli.online.service;

import com.momsdeli.online.dto.CategoryDTO;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 21/08/2024
 */
public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategories();
}
