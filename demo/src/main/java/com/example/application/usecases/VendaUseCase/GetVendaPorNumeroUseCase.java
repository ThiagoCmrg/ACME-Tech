package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.domain.interfaces.VendaRepository;

@Service
public class GetVendaPorNumeroUseCase {
    
    private final VendaRepository vendaRepository;
    
    public GetVendaPorNumeroUseCase(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public Optional<Venda> execute(Long numVenda) {
        return vendaRepository.findByIdWithRelations(numVenda);
    }
}
