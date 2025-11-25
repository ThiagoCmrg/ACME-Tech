package com.example.application.usecases.VendaUseCase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.entities.Venda;
import com.example.domain.entities.enums.Area;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class CalcularValorFinalVendaUseCase {
    
    private final VendaJPARepository vendaRepository;
    
    public CalcularValorFinalVendaUseCase(VendaJPARepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }
    
    public Double execute(Long numVenda) {
        Optional<Venda> vendaOpt = vendaRepository.findByIdWithRelations(numVenda);
        
        if (vendaOpt.isEmpty()) {
            return -1.0;
        }
        
        Venda venda = vendaOpt.get();
        
        // Validações para evitar NullPointerException
        if (venda.getTecnologia() == null) {
            throw new RuntimeException("Venda " + numVenda + " não possui tecnologia associada");
        }
        
        if (venda.getTecnologia().getFornecedor() == null) {
            throw new RuntimeException("Tecnologia da venda " + numVenda + " não possui fornecedor associado");
        }
        
        if (venda.getComprador() == null) {
            throw new RuntimeException("Venda " + numVenda + " não possui comprador associado");
        }
        
        //TODO: mover lógica de negócio para a domain service
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

