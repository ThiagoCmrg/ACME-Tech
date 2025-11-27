package com.example.application.usecases.CompradorUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.CompradorRequestDTO;
import com.example.domain.entities.Comprador;
import com.example.domain.interfaces.CompradorRepository;

@Service
public class PostCadastrarCompradorUseCase {

    private final CompradorRepository repo;

    public PostCadastrarCompradorUseCase(CompradorRepository repo) {
        this.repo = repo;
    }

    public boolean execute(CompradorRequestDTO dto) {

        if (dto.cod != null && repo.existsById(dto.cod))
            return false;

        Comprador comprador = new Comprador(
            dto.cod,
            dto.nome,
            dto.email,
            dto.pais
        );

        repo.save(comprador);
        return true;
    }
}
