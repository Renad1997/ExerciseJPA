package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "orderId should be not Null!")
    private Integer orderId;

    @NotNull(message = "userId should be not Null!")
    @Column(columnDefinition = "int not null")
    private int userId;

    @NotNull(message = "productId should be not Null!")
    @Column(columnDefinition = "int not null")
    private int productId;

    @NotNull(message = "merchantId should be not Null!")
    @Column(columnDefinition = "int not null")
    private int merchantId;

    @NotNull(message = "Price should be Not Null!")
    @Positive(message = "Price must be a number")
    @Column(columnDefinition = "double not null")
    private double price;

    @NotNull(message = "discount should be Not Null!")
    @Column(columnDefinition = "double not null")
    private double discount;

}
