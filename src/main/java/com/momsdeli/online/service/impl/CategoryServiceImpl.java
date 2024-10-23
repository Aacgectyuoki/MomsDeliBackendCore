package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.CategoryDTO;
import com.momsdeli.online.model.Category;
import com.momsdeli.online.repository.CategoryRepository;
import com.momsdeli.online.service.CategoryService;
import com.momsdeli.online.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        logger.info("Creating category: {}", categoryDTO);
        long startTime = System.currentTimeMillis();

        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);

        long endTime = System.currentTimeMillis();
        logger.info("Category created in {} ms", (endTime - startTime));

        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        logger.info("Updating category with id: {}", id);
        long startTime = System.currentTimeMillis();

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMapper.updateEntityFromDto(categoryDTO, category);
        category = categoryRepository.save(category);

        long endTime = System.currentTimeMillis();
        logger.info("Category updated in {} ms", (endTime - startTime));

        return categoryMapper.toDTO(category);
    }

    @Override
    public void deleteCategory(Long id) {
        logger.info("Deleting category with id: {}", id);
        long startTime = System.currentTimeMillis();

        categoryRepository.deleteById(id);

        long endTime = System.currentTimeMillis();
        logger.info("Category deleted in {} ms", (endTime - startTime));
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        logger.info("Fetching category by id: {}", id);
        long startTime = System.currentTimeMillis();

        Category category = categoryRepository.findCategoryById(id);
        if (category == null) {
            logger.warn("Category with id {} not found", id);
            throw new RuntimeException("Category not found");
        }

        long fetchTime = System.currentTimeMillis();
        logger.info("Category fetched in {} ms", (fetchTime - startTime));

        CategoryDTO categoryDTO = categoryMapper.toDTO(category);
        long endTime = System.currentTimeMillis();
        logger.info("Category converted to DTO in {} ms", (endTime - fetchTime));

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        logger.info("Fetching all categories");
        long startTime = System.currentTimeMillis();

        List<Category> categories = categoryRepository.findAllCategories();
        long fetchTime = System.currentTimeMillis();
        logger.info("Fetched all categories in {} ms", (fetchTime - startTime));

        List<CategoryDTO> categoryDTOs = categories.stream()
                .map(categoryMapper::toDTO).toList();
        long endTime = System.currentTimeMillis();
        logger.info("Converted categories to DTOs in {} ms", (endTime - fetchTime));

        return categoryDTOs;
    }

    @Override
    public List<CategoryDTO> searchCategoriesByName(String name) {
        logger.info("Fetching categories by name: {}", name);
        long startTime = System.currentTimeMillis();

        List<Category> categories = categoryRepository.findCategoriesByName(name);
        long fetchTime = System.currentTimeMillis();
        logger.info("Fetched categories by name in {} ms", (fetchTime - startTime));

        List<CategoryDTO> categoryDTOs = categories.stream()
                .map(categoryMapper::toDTO).toList();
        long endTime = System.currentTimeMillis();
        logger.info("Converted categories to DTOs in {} ms", (endTime - fetchTime));

        return categoryDTOs;
    }
}
