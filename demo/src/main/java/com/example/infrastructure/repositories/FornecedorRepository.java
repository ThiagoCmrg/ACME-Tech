package com.example.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
}
