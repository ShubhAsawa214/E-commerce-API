package com.E_commerce.API.E_commerce.API.Repository;

import com.E_commerce.API.E_commerce.API.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
