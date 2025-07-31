package com.E_commerce.API.E_commerce.API.Repository;

import com.E_commerce.API.E_commerce.API.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
