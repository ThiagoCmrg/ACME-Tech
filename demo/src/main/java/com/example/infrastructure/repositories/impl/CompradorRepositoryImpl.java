package com.example.infrastructure.repositories.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.domain.entities.Comprador;
import com.example.domain.interfaces.CompradorRepository;
import com.example.infrastructure.repositories.CompradorJPARepository;

@Repository
public class CompradorRepositoryImpl implements CompradorRepository {

    private final CompradorJPARepository jpa;

    public CompradorRepositoryImpl(CompradorJPARepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Comprador> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Comprador> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Comprador save(Comprador c) {
        return jpa.save(c);
    }

    @Override
    public boolean existsById(Long id) {
        return jpa.existsById(id);
    }
}
