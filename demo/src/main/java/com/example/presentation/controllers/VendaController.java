package com.example.presentation.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.DTO.VendaRequestDTO;
import com.example.application.usecases.VendaUseCase.CalcularValorFinalVendaUseCase;
import com.example.application.usecases.VendaUseCase.DeletarVendaUseCase;
import com.example.application.usecases.VendaUseCase.GetAllVendasUseCase;
import com.example.application.usecases.VendaUseCase.GetVendaPorNumeroUseCase;
import com.example.application.usecases.VendaUseCase.PostCadastrarVendaUseCase;
import com.example.domain.entities.Venda;

@RestController
public class VendaController {
    
    private final CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase;
    private final GetVendaPorNumeroUseCase getVendaPorNumeroUseCase;
    private final GetAllVendasUseCase getAllVendasUseCase;
    private final PostCadastrarVendaUseCase postCadastrarVendaUseCase;
    private final DeletarVendaUseCase deletarVendaUseCase;
    
    public VendaController(CalcularValorFinalVendaUseCase calcularValorFinalVendaUseCase,
                           GetVendaPorNumeroUseCase getVendaPorNumeroUseCase, GetAllVendasUseCase getAllVendasUseCase, PostCadastrarVendaUseCase postCadastrarVendaUseCase, DeletarVendaUseCase deletarVendaUseCase) {
        this.calcularValorFinalVendaUseCase = calcularValorFinalVendaUseCase;
        this.getVendaPorNumeroUseCase = getVendaPorNumeroUseCase;
        this.getAllVendasUseCase = getAllVendasUseCase;
        this.postCadastrarVendaUseCase = postCadastrarVendaUseCase;
        this.deletarVendaUseCase = deletarVendaUseCase;
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
        return getAllVendasUseCase.execute();
    }

    @PostMapping("/cadastrarvenda")
    public boolean cadastrarVenda(@RequestBody VendaRequestDTO dto) {
        return postCadastrarVendaUseCase.execute(dto);
    }

    @DeleteMapping("/deletarvenda/{num}")
    public boolean deletarVenda(@PathVariable Long num) {
        return deletarVendaUseCase.execute(num);
    }

}


