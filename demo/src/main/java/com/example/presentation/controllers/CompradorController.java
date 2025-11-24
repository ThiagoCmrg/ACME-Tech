package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.DTO.CompradorRequestDTO;
import com.example.application.usecases.CompradorUseCase.GetAllCompradoresUseCase;
import com.example.application.usecases.CompradorUseCase.PostCadastrarCompradorUseCase;
import com.example.application.usecases.VendaUseCase.GetComprasPeloComprador;
import com.example.domain.entities.Comprador;
import com.example.domain.entities.Venda;

@RestController
public class CompradorController {

    private final GetAllCompradoresUseCase getAllCompradoresUseCase;
    private final GetComprasPeloComprador getComprasPeloComprador;
    private final PostCadastrarCompradorUseCase postCadastrarCompradorUseCase;

    public CompradorController(GetAllCompradoresUseCase getAllCompradoresUseCase, GetComprasPeloComprador getComprasPeloComprador, PostCadastrarCompradorUseCase postCadastrarCompradorUseCase) {
        this.getAllCompradoresUseCase = getAllCompradoresUseCase;
        this.getComprasPeloComprador = getComprasPeloComprador;
        this.postCadastrarCompradorUseCase = postCadastrarCompradorUseCase;
    }

    @GetMapping("/listarcompradores")
    public List<Comprador> listarTodos() {
        return getAllCompradoresUseCase.execute();
    }

    @GetMapping("/compradores/{cod}/compras")
    public List<Venda> listarComprasPeloComprador(@PathVariable Long cod) {
        return getComprasPeloComprador.execute(cod);
    }

    @PostMapping("/cadastrarcomprador")
    public boolean cadastrarComprador(@RequestBody CompradorRequestDTO dto) {
        return postCadastrarCompradorUseCase.execute(dto);
    }
}
