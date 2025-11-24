package com.example.application.usecases.TecnologiaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Tecnologia;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Service
public class GetAllTecnologiasUseCase {

    private final TecnologiaJPARepository tecnologiaRepository;

    public GetAllTecnologiasUseCase(TecnologiaJPARepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public List<Tecnologia> getAllTecnologias() {
        return tecnologiaRepository.findAll();
    }
}
