package com.example.application.usecases.TecnologiaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Tecnologia;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Service
public class GetTecnologiasPeloFornecedorUseCase {

    private final TecnologiaJPARepository tecnologiaRepository;

    public GetTecnologiasPeloFornecedorUseCase(TecnologiaJPARepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public List<Tecnologia> getTecnologiaByFornecedorCod(Long fornecedorCod) {
        return tecnologiaRepository.findByFornecedorCod(fornecedorCod);
    }
    
}
