package com.example.application.usecases.TecnologiaUseCase;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Tecnologia;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Service
public class GetTecnologiaUseCase {

    private final TecnologiaJPARepository tecnologiaRepository;

    public GetTecnologiaUseCase(TecnologiaJPARepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public Tecnologia getTecnologiaById(Long id) {
        return tecnologiaRepository.findById(id).orElse(null);
    }
}
