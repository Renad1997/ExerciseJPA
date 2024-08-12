package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct() {
        return ResponseEntity.status(200).body(productService.getProduct());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id ,@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = productService.updateProduct(id, product);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Product Updated");
        }
        return ResponseEntity.status(400).body("Product not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        boolean isDeleted= productService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Product Deleted");
        }
        return ResponseEntity.status(400).body("Product not found");
    }


}
