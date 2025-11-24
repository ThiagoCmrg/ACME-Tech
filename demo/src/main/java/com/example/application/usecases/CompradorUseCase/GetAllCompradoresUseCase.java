package com.example.application.usecases.CompradorUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Comprador;
import com.example.infrastructure.repositories.CompradorJPARepository;

@Service
public class GetAllCompradoresUseCase {

    private final CompradorJPARepository repo;

    public GetAllCompradoresUseCase(CompradorJPARepository repo) {
        this.repo = repo;
    }

    public List<Comprador> getAllCompradores() {
        return repo.findAll();
    }
}
