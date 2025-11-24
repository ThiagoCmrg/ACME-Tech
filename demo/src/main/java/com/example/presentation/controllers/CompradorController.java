package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.CompradorUseCase.GetAllCompradoresUseCase;
import com.example.domain.entities.Comprador;

@RestController
public class CompradorController {

    private final GetAllCompradoresUseCase getAllCompradoresUseCase;

    public CompradorController(GetAllCompradoresUseCase getAllCompradoresUseCase) {
        this.getAllCompradoresUseCase = getAllCompradoresUseCase;
    }

    @GetMapping("/listarcompradores")
    public List<Comprador> listarTodos() {
        return getAllCompradoresUseCase.getAllCompradores();
    }
}
