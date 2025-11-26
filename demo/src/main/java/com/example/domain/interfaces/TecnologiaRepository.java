package com.example.domain.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.domain.entities.Tecnologia;

public interface TecnologiaRepository {
    List<Tecnologia> findAll();
    Optional<Tecnologia> findById(Long id);
    Tecnologia save(Tecnologia t);
    boolean existsById(Long id);
    List<Tecnologia> findByFornecedorCod(Long fornecedorCod);
}
