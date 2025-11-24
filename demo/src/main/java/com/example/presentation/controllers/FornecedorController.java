package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entities.Fornecedor;
import com.example.infrastructure.repositories.FornecedorRepository;


@RestController
@RequestMapping("/acmetech")
public class FornecedorController {

    private final FornecedorRepository repo;

    public FornecedorController(FornecedorRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/listarfornecedores")
    public List<Fornecedor> listarTodos() {
        return repo.findAll();
    }
}
