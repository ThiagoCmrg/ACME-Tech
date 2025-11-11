package com.example.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.VendaUseCase.CalcularValorFinalVendaUseCase;

@RestController
@RequestMapping("/acmetech")
public class VendaController {
    
    private final CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase;
    
    public VendaController(CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase) {
        this.calcularValorFinalVendaUseCase = calcularValorFinalVendaUseCase;
    }
    
    @GetMapping("/vendas/{num}/valorfinal")
    public Double getValorFinalVenda(@PathVariable Long num) {
        return calcularValorFinalVendaUseCase.execute(num);
    }
}

