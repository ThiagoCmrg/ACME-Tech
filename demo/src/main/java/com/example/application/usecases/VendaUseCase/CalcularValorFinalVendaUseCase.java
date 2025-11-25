package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.domain.services.VendaService;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class CalcularValorFinalVendaUseCase {
    
    private final VendaJPARepository vendaRepository;
    private final VendaService vendaService;

    public CalcularValorFinalVendaUseCase(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
        this.vendaService = new VendaService();
    }

    public Double execute(Long numVenda) {
        Optional<Venda> vendaOpt = vendaRepository.findByIdWithRelations(numVenda);

        if (vendaOpt.isEmpty()) {
            return -1.0;
        }

        Venda venda = vendaOpt.get();

        long vendasAnteriores = vendaRepository.countVendasAnterioresPorComprador(
            venda.getComprador().getCod(),
            numVenda
        );

        return vendaService.calcularValorFinal(venda, vendasAnteriores);
    }
}
