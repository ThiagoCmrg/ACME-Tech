package com.example.application.usecases.VendaUseCase;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.domain.entities.Venda;
import com.example.domain.interfaces.VendaRepository;

@Service
public class GetAllVendasUseCase {
    
    private final VendaRepository vendaRepository;
    
    public GetAllVendasUseCase(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public List<Venda> execute(){
        return vendaRepository.findAllActive();
    }
}
