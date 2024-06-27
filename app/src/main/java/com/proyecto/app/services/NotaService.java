package com.proyecto.app.services;

import java.util.List;

import com.proyecto.app.DTOs.NotaDTO;

public interface NotaService {

    List<NotaDTO> getAllNotas() throws Exception;
    void deleteNota(Integer id) throws Exception;
}

