package com.example.loja.ammunation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.loja.ammunation.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, UUID> {
}