package com.example.application.usecases.VendaUseCase;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.domain.interfaces.VendaRepository;

@Service
public class DeletarVendaUseCase {
    
    private final VendaRepository vendaRepository;

    public DeletarVendaUseCase(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public boolean execute(Long numVenda) {

        Optional<Venda> opt = vendaRepository.findByIdWithRelations(numVenda);

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
