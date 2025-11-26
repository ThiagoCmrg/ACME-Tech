package com.example.application.usecases.CompradorUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.CompradorRequestDTO;
import com.example.domain.entities.Comprador;
import com.example.domain.interfaces.CompradorRepository;

@Service
public class PutEditarCompradorUseCase {

    private final CompradorRepository repo;

    public PutEditarCompradorUseCase(CompradorRepository repo) {
        this.repo = repo;
    }

    public boolean execute(CompradorRequestDTO dto) {

        if (dto.cod == null) return false;

        var opt = repo.findById(dto.cod);
        if (opt.isEmpty()) return false;

        Comprador comprador = opt.get();
        comprador.setNome(dto.nome);
        comprador.setEmail(dto.email);
        comprador.setPais(dto.pais);

        repo.save(comprador);
        return true;
    }
}
