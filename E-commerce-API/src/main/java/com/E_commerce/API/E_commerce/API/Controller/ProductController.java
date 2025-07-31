package com.E_commerce.API.E_commerce.API.Controller;

import com.E_commerce.API.E_commerce.API.Entity.Product;
import com.E_commerce.API.E_commerce.API.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getproduct(){
        return productRepository.findAll();
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Product addChanges(@PathVariable Long id ,@RequestBody Product update){
        Product product=productRepository.findById(id).orElseThrow();
        product.setName(update.getName());
        product.setPrice(update.getPrice());
        product.setStock(update.getStock());
        return productRepository.save(update);
    }
}