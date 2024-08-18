package com.momsdeli.online.service;

import com.momsdeli.online.dto.CategoryDTO;
import com.momsdeli.online.mapper.CategoryMapper;
import com.momsdeli.online.model.Category;
import com.momsdeli.online.repository.CategoryRepository;
import com.momsdeli.online.request.CategoryRequest;
import com.momsdeli.online.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryResponse addCategory(CategoryRequest request) {
        Category category = categoryMapper.requestToCategory(request);
        category = categoryRepository.save(category);
        return categoryMapper.categoryToResponse(category);
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMapper.updateCategoryFromDTO(request, category);
        category = categoryRepository.save(category);
        return categoryMapper.categoryToResponse(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.categoryToResponse(category);
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToResponse)
                .collect(Collectors.toList());
    }
}
