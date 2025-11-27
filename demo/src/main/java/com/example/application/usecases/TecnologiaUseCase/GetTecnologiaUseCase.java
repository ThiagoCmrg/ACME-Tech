package com.example.application.usecases.TecnologiaUseCase;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Tecnologia;
import com.example.domain.interfaces.TecnologiaRepository;

@Service
public class GetTecnologiaUseCase {

    private final TecnologiaRepository tecnologiaRepository;

    public GetTecnologiaUseCase(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public Tecnologia execute(Long id) {
        return tecnologiaRepository.findById(id).orElse(null);
    }
}
