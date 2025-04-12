package com.example.productsShopping.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 1, max = 50, message = "Surname must be between 1 and 50 characters")
    @Column(name = "surname", unique = true)
    private String surname;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Username is required")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 1)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    // censs c kopswной
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();
}
