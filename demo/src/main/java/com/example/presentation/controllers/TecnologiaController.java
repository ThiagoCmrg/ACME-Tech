package com.example.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.TecnologiaUseCase.GetTecnologiaUseCase;
import com.example.domain.entities.Tecnologia;

@RestController
public class TecnologiaController {

    private final GetTecnologiaUseCase getTecnologiaUseCase;

    public TecnologiaController(GetTecnologiaUseCase getTecnologiaUseCase) {
        this.getTecnologiaUseCase = getTecnologiaUseCase;
    }

    @GetMapping("/buscatecnologia/{id}")
    public Tecnologia getTecnologia(@PathVariable Long id) {
        return getTecnologiaUseCase.getTecnologiaById(id);
    }
}
