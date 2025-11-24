package com.example.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.entities.Venda;

public interface VendaJPARepository extends JpaRepository<Venda, Long> {

    List<Venda> findByRemovidaFalse();
    List<Venda> findByCompradorCodAndRemovidaFalse(Long cod);

    
    @Query("SELECT COUNT(v) FROM Venda v WHERE v.comprador.cod = :compradorCod AND v.num < :numVendaAtual")
    long countVendasAnterioresPorComprador(@Param("compradorCod") Long compradorCod, @Param("numVendaAtual") Long numVendaAtual);
    
    @Query("SELECT v FROM Venda v " +
           "LEFT JOIN FETCH v.tecnologia t " +
           "LEFT JOIN FETCH t.fornecedor " +
           "LEFT JOIN FETCH v.comprador " +
           "WHERE v.num = :num")
    Optional<Venda> findByIdWithRelations(@Param("num") Long num);
}
