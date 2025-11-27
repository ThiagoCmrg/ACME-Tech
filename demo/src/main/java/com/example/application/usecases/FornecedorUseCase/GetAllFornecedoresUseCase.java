package com.example.application.usecases.FornecedorUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Fornecedor;
import com.example.domain.interfaces.FornecedorRepository;

@Service
public class GetAllFornecedoresUseCase {

    private final FornecedorRepository repo;

    public GetAllFornecedoresUseCase(FornecedorRepository repo) {
        this.repo = repo;
    }

    public List<Fornecedor> execute() {
        return repo.findAll();
    }
}
