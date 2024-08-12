package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should be Not Null!")
    private Integer id;

    @NotEmpty(message = "Name should be not Empty!")
    @Size(min = 3 , message = "Name should be more than 3 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;

    @NotNull(message = "Price should be Not Null!")
    @Positive(message = "Price must be a number")
    @Column(columnDefinition = "double not null")
    private double price;

    @NotNull(message = "CategoryID should be Not Null!")
    @Column(columnDefinition = "int not null")
    private int categoryId;
}
