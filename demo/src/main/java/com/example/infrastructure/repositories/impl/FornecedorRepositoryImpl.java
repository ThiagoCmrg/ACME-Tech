package com.example.infrastructure.repositories.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.domain.entities.Fornecedor;
import com.example.domain.interfaces.FornecedorRepository;
import com.example.infrastructure.repositories.FornecedorJPARepository;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepository {

    private final FornecedorJPARepository jpa;

    public FornecedorRepositoryImpl(FornecedorJPARepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Fornecedor> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Fornecedor> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpa.existsById(id);
    }
}
