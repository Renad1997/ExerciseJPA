package com.example.exercisejpa.Model;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should be not Null!")
    private Integer id;

    @NotEmpty(message = "username should be not Empty!")
    @Size(min = 5,message = "username have to be more than 5 characters")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;

    @NotEmpty(message = "password should be not Empty!")
    @Size(min = 6,message = "have to be more than 6 , must have characters and digits")
    @Pattern(regexp = "(^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$)",message = "")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String password;

    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Email must be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "Role should be not empty!")
    @Pattern(regexp="^(Admin|Customer)$",message = "Role must to be Admin or Customer")
    @Column(columnDefinition = "varchar(20) check(role='Admin' or role='Customer')")
    private String role;

    @NotNull(message = "Balance should be not Null!")
    @Positive(message = "Balance have to be positive")
    @Column(columnDefinition = "double not null")
    private double balance;

    @AssertFalse
    private boolean isPrimary;

}
