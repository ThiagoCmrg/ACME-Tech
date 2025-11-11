package com.example.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
    @Query("SELECT COUNT(v) FROM Venda v WHERE v.comprador.cod = :compradorCod AND v.num < :numVendaAtual")
    long countVendasAnterioresPorComprador(@Param("compradorCod") Long compradorCod, @Param("numVendaAtual") Long numVendaAtual);
}
