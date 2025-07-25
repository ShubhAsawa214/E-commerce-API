package com.E_commerce.API.E_commerce.API.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;  // PENDING, COMPLETED

    @ManyToMany
    private List<Product> products;
}
