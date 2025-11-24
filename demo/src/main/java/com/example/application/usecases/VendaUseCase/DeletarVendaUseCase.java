package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class DeletarVendaUseCase {
    
    private final VendaJPARepository vendaRepository;

    public DeletarVendaUseCase(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public boolean execute(Long numVenda) {

        Optional<Venda> opt = vendaRepository.findById(numVenda);

        if (opt.isEmpty())
            return false;

        Venda venda = opt.get();

        if (Boolean.TRUE.equals(venda.getRemovida()))
            return false;
        
        venda.setRemovida(true);
        vendaRepository.save(venda);

        return true;
    }

}