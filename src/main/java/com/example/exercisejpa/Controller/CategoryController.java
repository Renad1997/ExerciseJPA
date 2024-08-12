package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory() {
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id ,@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = categoryService.updateCategory(id,category);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Category Updated");
        }
        return ResponseEntity.status(400).body("Category not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        boolean isDeleted= categoryService.deleteCategory(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Category Deleted");
        }
        return ResponseEntity.status(400).body("Category not found");
    }

}
