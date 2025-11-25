package com.example.application.usecases.CompradorUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.CompradorRequestDTO;
import com.example.domain.entities.Comprador;
import com.example.infrastructure.repositories.CompradorJPARepository;

@Service
public class PutEditarCompradorUseCase {

    private final CompradorJPARepository compradorRepo;

    public PutEditarCompradorUseCase(CompradorJPARepository compradorRepo) {
        this.compradorRepo = compradorRepo;
    }

    public boolean execute(CompradorRequestDTO dto) {

        if (dto.cod == null) return false;

        var opt = compradorRepo.findById(dto.cod);
        if (opt.isEmpty()) return false;

        Comprador comprador = opt.get();
        comprador.setNome(dto.nome);
        comprador.setEmail(dto.email);
        comprador.setPais(dto.pais);

        compradorRepo.save(comprador);
        return true;
    }
}
