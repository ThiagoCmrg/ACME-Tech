package com.example.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entities.Comprador;

public interface CompradorJPARepository extends JpaRepository<Comprador, Long> {
    
}
