package com.example.application.usecases.TecnologiaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Tecnologia;
import com.example.domain.interfaces.TecnologiaRepository;

@Service
public class GetTecnologiasPeloFornecedorUseCase {

    private final TecnologiaRepository tecnologiaRepository;

    public GetTecnologiasPeloFornecedorUseCase(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public List<Tecnologia> execute(Long fornecedorCod) {
        return tecnologiaRepository.findByFornecedorCod(fornecedorCod);
    }
    
}
