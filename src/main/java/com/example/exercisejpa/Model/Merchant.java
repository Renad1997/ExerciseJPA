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
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should be Not Null!")
    private Integer id;

    @NotEmpty(message = "Name should be not Empty!")
    @Size(min = 3 , message = "Name should be more than 3 characters")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;

    @NotNull(message = "rate should be Not Null!")
    @Column(columnDefinition = "double not null")
    private double rate;

}
