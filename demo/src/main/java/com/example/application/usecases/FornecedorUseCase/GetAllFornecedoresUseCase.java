package com.example.application.usecases.FornecedorUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Fornecedor;
import com.example.infrastructure.repositories.FornecedorJPARepository;

@Service
public class GetAllFornecedoresUseCase {

    private final FornecedorJPARepository repo;

    public GetAllFornecedoresUseCase(FornecedorJPARepository repo) {
        this.repo = repo;
    }

    public List<Fornecedor> getAllFornecedores() {
        return repo.findAll();
    }
}
