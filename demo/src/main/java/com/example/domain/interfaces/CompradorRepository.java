package com.example.domain.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.domain.entities.Comprador;

public interface CompradorRepository {
    List<Comprador> findAll();
    Optional<Comprador> findById(Long id);
    Comprador save(Comprador c);
    boolean existsById(Long id);
}
