package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.domain.entities.enums.Area;
import com.example.infrastructure.repositories.VendaRepository;

@Service
public class CalcularValorFinalVendaUseCase {
    
    private final VendaRepository vendaRepository;
    
    public CalcularValorFinalVendaUseCase(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public Double execute(Long numVenda) {
        Optional<Venda> vendaOpt = vendaRepository.findById(numVenda);
        
        if (vendaOpt.isEmpty()) {
            return -1.0;
        }
        
        Venda venda = vendaOpt.get();
        Double valorBase = venda.getTecnologia().getValorBase();
        Area area = venda.getTecnologia().getFornecedor().getArea();
        
        Double valorComAcrescimo = aplicarAcrescimoPorArea(valorBase, area);
        
        long vendasAnteriores = vendaRepository.countVendasAnterioresPorComprador(
            venda.getComprador().getCod(), 
            numVenda
        );
        
        Double descontoPercentual = Math.min(vendasAnteriores * 1.0, 10.0);
        Double valorFinal = valorComAcrescimo * (1 - descontoPercentual / 100);
        
        return valorFinal;
    }
    
    private Double aplicarAcrescimoPorArea(Double valorBase, Area area) {
        return switch (area) {
            case TI -> valorBase * 1.20;
            case ANDROIDES -> valorBase * 1.15;
            case EMERGENTE -> valorBase * 1.25;
            case ALIMENTOS -> valorBase * 1.10;
        };
    }
}

