package com.E_commerce.API.E_commerce.API.Controller;

import com.E_commerce.API.E_commerce.API.Entity.Order;
import com.E_commerce.API.E_commerce.API.Entity.Product;
import com.E_commerce.API.E_commerce.API.Repository.OrderRepository;
import com.E_commerce.API.E_commerce.API.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @GetMapping
    public List<Order> getorder(){
        return orderRepository.findAll();
    }

    @PostMapping
    public Order addorder(@RequestBody Order order){
        for(Product p:order.getProducts()){
            productRepository.findById(p.getId()).orElseThrow();
        }order.setStatus("Pending");
        return orderRepository.save(order);
    }
    @PutMapping("/{id}")
    public Order update(@PathVariable Long id){
        Order order=orderRepository.findById(id).orElseThrow();
        order.setStatus("COmplete");
        return orderRepository.save(order);
    }

}
