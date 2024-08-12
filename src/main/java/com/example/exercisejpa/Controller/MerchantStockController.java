package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("Merchant Stock Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer id ,@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Merchant Stock Updated");
        }
        return ResponseEntity.status(400).body("Merchant Stock not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id) {
        boolean isDeleted= merchantStockService.deleteMerchantStock(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Merchant Stock Deleted");
        }
        return ResponseEntity.status(400).body("Merchant Stock not found");
    }
}
