package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class GetVendaPorNumeroUseCase {
    
    private final VendaJPARepository vendaRepository;
    
    public GetVendaPorNumeroUseCase(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public Optional<Venda> execute(Long numVenda) {
        return vendaRepository.findByIdWithRelations(numVenda);
    }
}
