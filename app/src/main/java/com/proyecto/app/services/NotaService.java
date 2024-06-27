package com.proyecto.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.app.models.Nota;
import com.proyecto.app.repository.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas() throws Exception {
        try {
            return notaRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching notas: " + e.getMessage());
        }
    }

    public Nota saveNota (Nota nota) throws Exception {
        try {
            return notaRepository.save(nota);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
        
    }

    
}
