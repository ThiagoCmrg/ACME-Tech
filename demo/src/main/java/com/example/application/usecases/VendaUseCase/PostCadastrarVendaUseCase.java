package com.example.application.usecases.VendaUseCase;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.example.application.DTO.VendaRequestDTO;
import com.example.domain.entities.Venda;
import com.example.domain.interfaces.CompradorRepository;
import com.example.domain.interfaces.TecnologiaRepository;
import com.example.domain.interfaces.VendaRepository;

@Service
public class PostCadastrarVendaUseCase {

    private final VendaRepository vendaRepo;
    private final TecnologiaRepository tecnologiaRepo;
    private final CompradorRepository compradorRepo;

    public PostCadastrarVendaUseCase(
        VendaRepository vendaRepo,
        TecnologiaRepository tecnologiaRepo,
        CompradorRepository compradorRepo
    ) {
        this.vendaRepo = vendaRepo;
        this.tecnologiaRepo = tecnologiaRepo;
        this.compradorRepo = compradorRepo;
    }

    public boolean execute(VendaRequestDTO dto) {
        try {

            var tecnologiaOpt = tecnologiaRepo.findById(dto.tecnologiaId);
            if (tecnologiaOpt.isEmpty())
                return false;

            var compradorOpt = compradorRepo.findById(dto.compradorCod);
            if (compradorOpt.isEmpty())
                return false;

            if (vendaRepo.existsById(dto.num)) {
                return false;
            }

            var sdf = new SimpleDateFormat("yyyy-MM-dd");
            var data = sdf.parse(dto.data);

            Venda venda = new Venda(
                dto.num,
                data,
                dto.valorFinal,
                tecnologiaOpt.get(), 
                compradorOpt.get()    
            );

            vendaRepo.save(venda);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
