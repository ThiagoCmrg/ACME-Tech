package com.example.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.DTO.TecnologiaRequestDTO;
import com.example.application.usecases.TecnologiaUseCase.GetAllTecnologiasUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiaUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiasPeloFornecedorUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiasPorPesoLibrasUseCase;
import com.example.application.usecases.TecnologiaUseCase.GetTecnologiasPorTemperaturaFahrenheitUseCase;
import com.example.application.usecases.TecnologiaUseCase.PostCadastrarTecnologiaUseCase;
import com.example.domain.entities.Tecnologia;



@RestController
public class TecnologiaController {

    private final GetTecnologiaUseCase getTecnologiaUseCase;
    private final GetAllTecnologiasUseCase getAllTecnologiasUseCase;
    private final GetTecnologiasPeloFornecedorUseCase getTecnologiasPeloFornecedorUseCase;
    private final PostCadastrarTecnologiaUseCase postCadastrarTecnologiaUseCase;
    private final GetTecnologiasPorTemperaturaFahrenheitUseCase getTecnologiasPorTemperaturaFahrenheitUseCase;
    private final GetTecnologiasPorPesoLibrasUseCase getTecnologiasPorPesoLibrasUseCase;

    public TecnologiaController(GetTecnologiaUseCase getTecnologiaUseCase, GetAllTecnologiasUseCase getAllTecnologiasUseCase, GetTecnologiasPeloFornecedorUseCase getTecnologiasPeloFornecedorUseCase, PostCadastrarTecnologiaUseCase postCadastrarTecnologiaUseCase, GetTecnologiasPorTemperaturaFahrenheitUseCase getTecnologiasPorTemperaturaFahrenheitUseCase, GetTecnologiasPorPesoLibrasUseCase getTecnologiasPorPesoLibrasUseCase
    ) {
        this.getTecnologiaUseCase = getTecnologiaUseCase;
        this.getAllTecnologiasUseCase = getAllTecnologiasUseCase;
        this.getTecnologiasPeloFornecedorUseCase = getTecnologiasPeloFornecedorUseCase;
        this.postCadastrarTecnologiaUseCase = postCadastrarTecnologiaUseCase;
        this.getTecnologiasPorTemperaturaFahrenheitUseCase = getTecnologiasPorTemperaturaFahrenheitUseCase;
        this.getTecnologiasPorPesoLibrasUseCase = getTecnologiasPorPesoLibrasUseCase;
    }

    @GetMapping("/buscatecnologia/{id}")
    public Tecnologia getTecnologia(@PathVariable Long id) {
        return getTecnologiaUseCase.execute(id);
    }

    @GetMapping("/listartecnologias")
    public List<Tecnologia> listaTecnologias() {
        return getAllTecnologiasUseCase.execute();
    }

    @GetMapping("/tecnologiaspelofornecedor/{cod}")
    public List<Tecnologia> getMethodName(@PathVariable Long cod) {
        return getTecnologiasPeloFornecedorUseCase.execute(cod);
    }

    @PostMapping("/cadastrartecnologia")
    public boolean cadastrarTecnologia(@RequestBody TecnologiaRequestDTO dto) {
        return postCadastrarTecnologiaUseCase.execute(dto);
    }
    
    @GetMapping("/tecnologias/temperatura")
    public List<Tecnologia> listarPorTemperatura(@RequestParam double fahrenheit) {
        return getTecnologiasPorTemperaturaFahrenheitUseCase.execute(fahrenheit);
    }

    @GetMapping("/tecnologias/peso")
    public List<Tecnologia> getTecnologiasPorPeso(@RequestParam double pesoLibras) {
        return getTecnologiasPorPesoLibrasUseCase.execute(pesoLibras);
    }
    
}
