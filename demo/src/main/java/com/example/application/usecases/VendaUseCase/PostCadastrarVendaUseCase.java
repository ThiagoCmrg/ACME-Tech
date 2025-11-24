package com.example.application.usecases.VendaUseCase;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.example.application.DTO.VendaRequestDTO;
import com.example.domain.entities.Venda;
import com.example.infrastructure.repositories.CompradorJPARepository;
import com.example.infrastructure.repositories.TecnologiaJPARepository;
import com.example.infrastructure.repositories.VendaJPARepository;

@Service
public class PostCadastrarVendaUseCase {

    private final VendaJPARepository vendaRepo;
    private final TecnologiaJPARepository tecnologiaRepo;
    private final CompradorJPARepository compradorRepo;

    public PostCadastrarVendaUseCase(
        VendaJPARepository vendaRepo,
        TecnologiaJPARepository tecnologiaRepo,
        CompradorJPARepository compradorRepo
    ) {
        this.vendaRepo = vendaRepo;
        this.tecnologiaRepo = tecnologiaRepo;
        this.compradorRepo = compradorRepo;
    }

    public boolean execute(VendaRequestDTO dto) {
        try {

            var tecnologia = tecnologiaRepo.findById(dto.tecnologiaId).orElse(null);
            if (tecnologia == null)
                return false;

            var comprador = compradorRepo.findById(dto.compradorCod).orElse(null);
            if (comprador == null)
                return false;

            var sdf = new SimpleDateFormat("yyyy-MM-dd");
            var data = sdf.parse(dto.data);

            Venda venda = new Venda(
                dto.num,
                data,
                dto.valorFinal,
                tecnologia,
                comprador
            );

            vendaRepo.save(venda);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
}
