package com.example.application.usecases.VendaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class GetComprasPeloComprador {
    
    private final VendaJPARepository vendaRepository;
    
    public GetComprasPeloComprador(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public List<Venda> execute(Long codComprador) {
        return vendaRepository.findByCompradorCodAndRemovidaFalse(codComprador);
    }
    
}
