package com.example.domain.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.domain.entities.Fornecedor;

public interface FornecedorRepository {
    List<Fornecedor> findAll();
    Optional<Fornecedor> findById(Long id);
    boolean existsById(Long id);
}
