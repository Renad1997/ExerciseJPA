package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Order;
import com.example.exercisejpa.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getOrder(){
        return ResponseEntity.status(200).body(orderService.getOrder());
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        orderService.addOrder(order);
        return ResponseEntity.status(200).body("Order Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id ,@Valid @RequestBody Order order, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = orderService.updateOrder(id,order);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Order Updated");
        }
        return ResponseEntity.status(400).body("Order not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        boolean isDeleted= orderService.deleteOrder(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Order Deleted");
        }
        return ResponseEntity.status(400).body("Order not found");
    }



}
