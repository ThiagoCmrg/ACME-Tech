package com.example.application.usecases.VendaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class GetAllVendasUseCase {
    
    private final VendaJPARepository vendaRepository;
    
    public GetAllVendasUseCase(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public List<Venda> getAllVendas(){
        return vendaRepository.findAll();
    }
}
