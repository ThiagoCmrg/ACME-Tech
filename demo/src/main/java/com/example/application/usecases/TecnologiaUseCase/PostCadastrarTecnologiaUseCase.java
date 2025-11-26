package com.example.application.usecases.TecnologiaUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.TecnologiaRequestDTO;
import com.example.domain.entities.Tecnologia;
import com.example.domain.interfaces.FornecedorRepository;
import com.example.domain.interfaces.TecnologiaRepository;

@Service
public class PostCadastrarTecnologiaUseCase {

    private final TecnologiaRepository tecnologiaRepo;
    private final FornecedorRepository fornecedorRepo;

    public PostCadastrarTecnologiaUseCase(
            TecnologiaRepository tecnologiaRepo,
            FornecedorRepository fornecedorRepo) {

        this.tecnologiaRepo = tecnologiaRepo;
        this.fornecedorRepo = fornecedorRepo;
    }

    public boolean execute(TecnologiaRequestDTO dto) {

        var fornecedor = fornecedorRepo.findById(dto.fornecedorCod)
                .orElse(null);

        if (fornecedor == null)
            return false;

        if (tecnologiaRepo.existsById(dto.id)) 
            return false;

        Tecnologia tecnologia = new Tecnologia(
            dto.id,
            dto.modelo,
            dto.descricao,
            dto.valorBase,
            dto.peso,
            dto.temperatura,
            fornecedor
        );

        tecnologiaRepo.save(tecnologia);
        return true;
    }


}
