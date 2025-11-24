package com.example.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.entities.Fornecedor;
import com.example.infrastructure.repositories.FornecedorJPARepository;

public class FornecedorController {

    private final FornecedorJPARepository repo;

    public FornecedorController(FornecedorJPARepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/listarfornecedores")
    public List<Fornecedor> listarTodos() {
        return repo.findAll();
    }
}
