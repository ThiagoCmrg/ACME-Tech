package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.usecases.CompradorUseCase.GetAllCompradoresUseCase;
import com.example.application.usecases.VendaUseCase.GetComprasPeloComprador;
import com.example.domain.entities.Comprador;
import com.example.domain.entities.Venda;

@RestController
public class CompradorController {

    private final GetAllCompradoresUseCase getAllCompradoresUseCase;
    private final GetComprasPeloComprador getComprasPeloComprador;

    public CompradorController(GetAllCompradoresUseCase getAllCompradoresUseCase, GetComprasPeloComprador getComprasPeloComprador) {
        this.getAllCompradoresUseCase = getAllCompradoresUseCase;
        this.getComprasPeloComprador = getComprasPeloComprador;
    }

    @GetMapping("/listarcompradores")
    public List<Comprador> listarTodos() {
        return getAllCompradoresUseCase.getAllCompradores();
    }

    @GetMapping("/compradores/{cod}/compras")
    public List<Venda> listarComprasPeloComprador(@PathVariable Long cod) {
        return getComprasPeloComprador.execute(cod);
    }
}
