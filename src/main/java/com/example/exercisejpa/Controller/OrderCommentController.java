package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.OrderComment;
import com.example.exercisejpa.Service.OrderCommentService;
import com.example.exercisejpa.Service.OrderService;
import com.example.exercisejpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class OrderCommentController {

    private final OrderCommentService orderCommentService;
    private final ProductService productService;

    ArrayList<OrderComment> comments = new ArrayList<OrderComment>();

    private final OrderService orderService;


    @PostMapping("/add/comment/{orderId}/{comment}")
    public ResponseEntity addOrderComment(@PathVariable Integer orderId, @PathVariable String comment) {
        if(!orderService.isOrderExist(orderId)){
            String message = "Order id " + orderId + " does not exist";
            return ResponseEntity.status(404).body(message);

        }
        orderCommentService.addOrderComment(new OrderComment(comment, orderId));
        return ResponseEntity.status(200).body("Comment added");
    }

    @GetMapping("/get/comment/{orderId}")
    public ResponseEntity getOrderComment(@PathVariable Integer orderId) {
        if(!orderCommentService.isOrderExist(orderId)){
            String message = "Order id " + orderId + " does not exist";
            return ResponseEntity.status(404).body(message);
        }
        ArrayList<OrderComment> comments = orderCommentService.getOrderComment(orderId);
        return ResponseEntity.status(200).body(comments);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrderComment(@PathVariable Integer id , @Valid @RequestBody OrderComment orderComment, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = orderCommentService.updateOrderComment(id,orderComment);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Comment Updated");
        }
        return ResponseEntity.status(400).body("Comment not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrderComment(@PathVariable Integer id) {
        boolean isDeleted= orderCommentService.deleteOrderComment(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Comment Deleted");
        }
        return ResponseEntity.status(400).body("Comment not found");
    }


}
