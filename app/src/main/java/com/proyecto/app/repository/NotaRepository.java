package com.proyecto.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.app.models.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {


}
