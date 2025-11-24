package com.example.application.usecases.TecnologiaUseCase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.entities.Tecnologia;
import com.example.infrastructure.repositories.TecnologiaJPARepository;

@Service
public class GetTecnologiasPorTemperaturaFahrenheitUseCase {
    private final TecnologiaJPARepository tecnologiaRepo;
    private final RestTemplate restTemplate;

    public GetTecnologiasPorTemperaturaFahrenheitUseCase(TecnologiaJPARepository tecnologiaRepo) {
        this.tecnologiaRepo = tecnologiaRepo;
        this.restTemplate = new RestTemplate();
    }

    public List<Tecnologia> execute(double temperaturaFahrenheit) {

    List<Tecnologia> tecnologias = tecnologiaRepo.findAll();

        return tecnologias.stream()
                .filter(t -> {
                    double tempConvertida = restTemplate.getForObject(
                        "https://w3bccgc1-8000.brs.devtunnels.ms/conversor/temperatura?origem=celsius&destino=fahrenheit&valor=" + t.getTemperatura(),
                        Double.class
                    );
                    return tempConvertida <= temperaturaFahrenheit;
                })
                .collect(Collectors.toList());
    }
}
