package com.th.taskproject.controllers;

import com.th.taskproject.dtos.CategoryCreateDTO;
import com.th.taskproject.dtos.CategoryGetDTO;
import com.th.taskproject.dtos.CategoryUpdateDTO;
import com.th.taskproject.entities.Category;
import com.th.taskproject.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryGetDTO>> getAllCategories(){
        List<CategoryGetDTO> request = categoryService.findAllCategories();
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryGetDTO> getCategoryById(@PathVariable Long id){
        CategoryGetDTO request = categoryService.findCategoryById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<CategoryGetDTO> createCategory(@Valid @RequestBody CategoryCreateDTO dto){

        CategoryGetDTO category = categoryService.createCategory(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryGetDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryUpdateDTO dto){
        CategoryGetDTO category = categoryService.updateCategory(id, dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
