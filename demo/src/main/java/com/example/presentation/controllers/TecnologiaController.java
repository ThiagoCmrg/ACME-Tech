package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.TecnologiaUseCase.GetAllTecnologiasUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiaUseCase;
import com.example.domain.entities.Tecnologia;


@RestController
public class TecnologiaController {

    private final GetTecnologiaUseCase getTecnologiaUseCase;
    private final GetAllTecnologiasUseCase getAllTecnologiasUseCase;

    public TecnologiaController(GetTecnologiaUseCase getTecnologiaUseCase, GetAllTecnologiasUseCase getAllTecnologiasUseCase) {
        this.getTecnologiaUseCase = getTecnologiaUseCase;
        this.getAllTecnologiasUseCase = getAllTecnologiasUseCase;
    }

    @GetMapping("/buscatecnologia/{id}")
    public Tecnologia getTecnologia(@PathVariable Long id) {
        return getTecnologiaUseCase.getTecnologiaById(id);
    }

    @GetMapping("/listartecnologias")
    public List<Tecnologia> listaTecnologias() {
        return getAllTecnologiasUseCase.getAllTecnologias();
    }
    
}
