package com.example.infrastructure.repositories.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.domain.entities.Tecnologia;
import com.example.domain.interfaces.TecnologiaRepository;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Repository
public class TecnologiaRepositoryImpl implements TecnologiaRepository {

    private final TecnologiaJPARepository jpa;

    public TecnologiaRepositoryImpl(TecnologiaJPARepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Tecnologia> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Tecnologia> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Tecnologia save(Tecnologia t) {
        return jpa.save(t);
    }

    @Override
    public boolean existsById(Long id) {
        return jpa.existsById(id);
    }

    @Override
    public List<Tecnologia> findByFornecedorCod(Long fornecedorCod) {
        return jpa.findByFornecedorCod(fornecedorCod);
    }
}
