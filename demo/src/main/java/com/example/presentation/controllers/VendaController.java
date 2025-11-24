package com.example.presentation.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.VendaUseCase.CalcularValorFinalVendaUseCase;
import com.example.application.usecases.VendaUseCase.GetAllVendasUseCase;
import com.example.application.usecases.VendaUseCase.GetVendaPorNumeroUseCase;
import com.example.domain.entities.Venda;

@RestController
public class VendaController {
    
    private final CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase;
    private final GetVendaPorNumeroUseCase getVendaPorNumeroUseCase;
    private final GetAllVendasUseCase getAllVendasUseCase;
    
    public VendaController(CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase,
                           GetVendaPorNumeroUseCase getVendaPorNumeroUseCase, GetAllVendasUseCase getAllVendasUseCase) {
        this.calcularValorFinalVendaUseCase = calcularValorFinalVendaUseCase;
        this.getVendaPorNumeroUseCase = getVendaPorNumeroUseCase;
        this.getAllVendasUseCase = getAllVendasUseCase;
    }
    
    @GetMapping("/vendas/{num}/valorfinal")
    public Double getValorFinalVenda(@PathVariable Long num) {
        return calcularValorFinalVendaUseCase.execute(num);
    }
    
    @GetMapping("/vendas/{num}")
    public Optional<Venda> getVendaPorNumero(@PathVariable Long num) {
        return getVendaPorNumeroUseCase.execute(num);
    }

    @GetMapping("/listarvendas")
    public List<Venda> listarTodasAsVendas() {
        return getAllVendasUseCase.getAllVendas();
    }
}


