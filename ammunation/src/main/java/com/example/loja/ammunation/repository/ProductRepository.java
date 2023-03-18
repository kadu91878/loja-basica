package com.example.loja.ammunation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.loja.ammunation.entity.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
