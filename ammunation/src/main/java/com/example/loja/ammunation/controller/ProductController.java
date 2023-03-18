package com.example.loja.ammunation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.ammunation.entity.Product;
import com.example.loja.ammunation.repository.ProductRepository;

@RestController
@RequestMapping("/api/Products")
public class ProductController {

    @Autowired
    private ProductRepository ProductRepository;

    @GetMapping
    public List<Product> getProducts() {
        return ProductRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return ProductRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product Product) {
        return ProductRepository.save(Product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody Product newProduct) {
        return ProductRepository.findById(id)
                .map(Product -> {
                    Product.setName(newProduct.getName());
                    Product.setDescription(newProduct.getDescription());
                    Product.setPrice(newProduct.getPrice());
                    Product.setType(newProduct.getType());

                    return ProductRepository.save(Product);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        ProductRepository.deleteById(id);
    }
}
