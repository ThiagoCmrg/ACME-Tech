package com.example.application.usecases.TecnologiaUseCase;

import org.springframework.stereotype.Service;

import com.example.application.DTO.TecnologiaRequestDTO;
import com.example.domain.entities.Tecnologia;
import com.example.infrastructure.repositories.FornecedorJPARepository;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Service
public class PostCadastrarTecnologiaUseCase {

    private final TecnologiaJPARepository tecnologiaRepo;
    private final FornecedorJPARepository fornecedorRepo;

    public PostCadastrarTecnologiaUseCase(
            TecnologiaJPARepository tecnologiaRepo,
            FornecedorJPARepository fornecedorRepo) {

        this.tecnologiaRepo = tecnologiaRepo;
        this.fornecedorRepo = fornecedorRepo;
    }

    public boolean execute(TecnologiaRequestDTO dto) {

        var fornecedor = fornecedorRepo.findById(dto.fornecedorCod)
                .orElse(null);

        if (fornecedor == null)
            return false;

        // Impede ID duplicado
        if (tecnologiaRepo.existsById(dto.id)) {
            return false;
        }

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
