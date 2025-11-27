package com.example.domain.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.domain.entities.Venda;

public interface VendaRepository {

    List<Venda> findAllActive();
    List<Venda> findByComprador(Long compradorCod);

    long countVendasAnteriores(Long compradorCod, Long numVendaAtual);

    Optional<Venda> findByIdWithRelations(Long num);

    Venda save(Venda venda);

    boolean existsById(Long num);
}
