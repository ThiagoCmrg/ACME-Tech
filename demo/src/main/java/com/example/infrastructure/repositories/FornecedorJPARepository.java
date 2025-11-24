package com.example.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entities.Fornecedor;

public interface FornecedorJPARepository extends JpaRepository<Fornecedor, Long>{
    
}
