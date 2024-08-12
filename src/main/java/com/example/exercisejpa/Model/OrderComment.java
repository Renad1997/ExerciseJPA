package com.example.exercisejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class OrderComment {


    @NotEmpty(message = "Comment should be not empty!")
    @Size(min = 50,message = "maximum character in comments is 50")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String comment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "OrderId should be not null!")
    private Integer orderId;
}
