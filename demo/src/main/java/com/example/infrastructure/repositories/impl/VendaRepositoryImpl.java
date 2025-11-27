package com.example.infrastructure.repositories.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.domain.entities.Venda;
import com.example.domain.interfaces.VendaRepository;
import com.example.infrastructure.repositories.VendaJPARepository;

@Repository
public class VendaRepositoryImpl implements VendaRepository {

    private final VendaJPARepository jpa;

    public VendaRepositoryImpl(VendaJPARepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Venda> findAllActive() {
        return jpa.findByRemovidaFalse();
    }

    @Override
    public List<Venda> findByComprador(Long compradorCod) {
        return jpa.findByCompradorCodAndRemovidaFalse(compradorCod);
    }

    @Override
    public long countVendasAnteriores(Long compradorCod, Long numVendaAtual) {
        return jpa.countVendasAnterioresPorComprador(compradorCod, numVendaAtual);
    }

    @Override
    public Optional<Venda> findByIdWithRelations(Long num) {
        return jpa.findByIdWithRelations(num);
    }

    @Override
    public Venda save(Venda venda) {
        return jpa.save(venda);
    }

    @Override
    public boolean existsById(Long num) {
        return jpa.existsById(num);
    }
}
