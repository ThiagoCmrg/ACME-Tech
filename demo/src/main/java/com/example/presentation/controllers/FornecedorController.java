package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.FornecedorUseCase.GetAllFornecedoresUseCase;
import com.example.domain.entities.Fornecedor;

@RestController
public class FornecedorController {

    private final GetAllFornecedoresUseCase getAllFornecedoresUseCase;

    public FornecedorController(GetAllFornecedoresUseCase getAllFornecedoresUseCase) {
        this.getAllFornecedoresUseCase = getAllFornecedoresUseCase;
    }

    @GetMapping("/listarfornecedores")
    public List<Fornecedor> listarTodos() {
        return getAllFornecedoresUseCase.getAllFornecedores();
    }
}
