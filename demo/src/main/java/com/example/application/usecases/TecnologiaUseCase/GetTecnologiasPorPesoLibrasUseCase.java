package com.example.application.usecases.TecnologiaUseCase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.entities.Tecnologia;
import com.example.domain.interfaces.TecnologiaRepository;


@Service
public class GetTecnologiasPorPesoLibrasUseCase {

    private final TecnologiaRepository tecnologiaRepo;
    private final RestTemplate restTemplate;

    public GetTecnologiasPorPesoLibrasUseCase(TecnologiaRepository tecnologiaRepo) {
        this.tecnologiaRepo = tecnologiaRepo;
        this.restTemplate = new RestTemplate();
    }

    public List<Tecnologia> execute(double pesoLibras) {
        List<Tecnologia> tecnologias = tecnologiaRepo.findAll();

        return tecnologias.stream()
                .filter(t -> {
                    double pesoConvertido = restTemplate.getForObject(
                        "https://w3bccgc1-8000.brs.devtunnels.ms/conversor/peso?origem=quilo&destino=libra&valor=" + t.getPeso(),
                        Double.class
                    );
                    return pesoConvertido <= pesoLibras;
                })
                .collect(Collectors.toList());
    }
}
