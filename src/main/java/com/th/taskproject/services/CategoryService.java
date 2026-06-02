package com.th.taskproject.services;

import com.th.taskproject.dtos.CategoryCreateDTO;
import com.th.taskproject.dtos.CategoryGetDTO;
import com.th.taskproject.dtos.CategoryUpdateDTO;
import com.th.taskproject.entities.Category;
import com.th.taskproject.exceptions.ResourceNotFoundException;
import com.th.taskproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryGetDTO convertToDTO(Category category){
        return new CategoryGetDTO(
                category.getId(),
                category.getName()
        );
    }

    public List<CategoryGetDTO> findAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public CategoryGetDTO findCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        return convertToDTO(category);
    }

    public CategoryGetDTO createCategory(CategoryCreateDTO dto){
        Category category = new Category();
        category.setName(dto.getName());

        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    public CategoryGetDTO updateCategory(Long id, CategoryUpdateDTO dto){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        category.setName(dto.getName());

        Category updatedCategory = categoryRepository.save(category);

        return convertToDTO(updatedCategory);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));

        categoryRepository.delete(category);
    }
}
