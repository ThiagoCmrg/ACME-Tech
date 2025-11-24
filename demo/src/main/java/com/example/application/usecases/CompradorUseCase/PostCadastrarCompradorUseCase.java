package com.example.application.usecases.CompradorUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.CompradorRequestDTO;
import com.example.domain.entities.Comprador;
import com.example.infrastructure.repositories.CompradorJPARepository;

@Service
public class PostCadastrarCompradorUseCase {

    private final CompradorJPARepository compradorRepo;

    public PostCadastrarCompradorUseCase(CompradorJPARepository compradorRepo) {
        this.compradorRepo = compradorRepo;
    }

    public boolean execute(CompradorRequestDTO dto) {

        if (dto.cod != null && compradorRepo.existsById(dto.cod))
            return false;

        Comprador comprador = new Comprador(
            dto.cod,
            dto.nome,
            dto.email,
            dto.pais
        );

        compradorRepo.save(comprador);

        return true;
    }
    
}
