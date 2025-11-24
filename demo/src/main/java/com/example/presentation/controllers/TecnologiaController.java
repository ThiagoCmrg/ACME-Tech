package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.DTO.TecnologiaRequestDTO;
import com.example.application.usecases.TecnologiaUseCase.GetAllTecnologiasUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiaUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiasPeloFornecedorUseCase;
import com.example.application.usecases.TecnologiaUseCase.PostCadastrarTecnologiaUseCase;
import com.example.domain.entities.Tecnologia;



@RestController
public class TecnologiaController {

    private final GetTecnologiaUseCase getTecnologiaUseCase;
    private final GetAllTecnologiasUseCase getAllTecnologiasUseCase;
    private final GetTecnologiasPeloFornecedorUseCase getTecnologiasPeloFornecedorUseCase;
    private final PostCadastrarTecnologiaUseCase postCadastrarTecnologiaUseCase;

    public TecnologiaController(GetTecnologiaUseCase getTecnologiaUseCase, GetAllTecnologiasUseCase getAllTecnologiasUseCase, GetTecnologiasPeloFornecedorUseCase getTecnologiasPeloFornecedorUseCase, PostCadastrarTecnologiaUseCase postCadastrarTecnologiaUseCase) {
        this.getTecnologiaUseCase = getTecnologiaUseCase;
        this.getAllTecnologiasUseCase = getAllTecnologiasUseCase;
        this.getTecnologiasPeloFornecedorUseCase = getTecnologiasPeloFornecedorUseCase;
        this.postCadastrarTecnologiaUseCase = postCadastrarTecnologiaUseCase;
    }

    @GetMapping("/buscatecnologia/{id}")
    public Tecnologia getTecnologia(@PathVariable Long id) {
        return getTecnologiaUseCase.getTecnologiaById(id);
    }

    @GetMapping("/listartecnologias")
    public List<Tecnologia> listaTecnologias() {
        return getAllTecnologiasUseCase.getAllTecnologias();
    }

    @GetMapping("/tecnologiaspelofornecedor/{cod}")
    public List<Tecnologia> getMethodName(@PathVariable Long cod) {
        return getTecnologiasPeloFornecedorUseCase.getTecnologiaByFornecedorCod(cod);
    }

    @PostMapping("/cadastrartecnologia")
    public boolean cadastrar(@RequestBody TecnologiaRequestDTO dto) {
        return postCadastrarTecnologiaUseCase.execute(dto);
    }
    
    
}
