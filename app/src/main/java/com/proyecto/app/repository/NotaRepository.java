package com.proyecto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.app.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{
    
}
