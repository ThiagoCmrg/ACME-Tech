package com.example.application.usecases.CompradorUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Comprador;
import com.example.domain.interfaces.CompradorRepository;

@Service
public class GetAllCompradoresUseCase {

    private final CompradorRepository repo;

    public GetAllCompradoresUseCase(CompradorRepository repo) {
        this.repo = repo;
    }

    public List<Comprador> execute() {
        return repo.findAll();
    }
}
