package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should be Not Null!")
    private Integer id;

    @NotNull(message = "productId should be not Null!")
    @Column(columnDefinition = "int not null")
    private int productId;

    @NotNull(message = "MerchantId should be Not Null!")
    @Column(columnDefinition = "int not null")
    private int merchantId;

    @NotNull(message = "Stock should be Not Null!")
    @Size(min = 10,message = "have to be more than 10 at start")
    @Column(columnDefinition = "int not null")
    private int stock;
}
