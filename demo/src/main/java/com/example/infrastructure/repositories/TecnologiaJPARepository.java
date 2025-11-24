package com.example.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entities.Tecnologia;

public interface TecnologiaJPARepository extends JpaRepository<Tecnologia, Long> {
}
