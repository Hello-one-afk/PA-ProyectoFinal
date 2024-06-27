package com.proyecto.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.app.models.Nota;
import com.proyecto.app.repository.NotaRepository;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Nota getNotaById(Integer id) {
        return notaRepository.findById(id).orElse(null);
    }

    public Nota createNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota updateNota(Integer id, Nota notaDetails) {
        Nota nota = notaRepository.findById(id).orElse(null);
        if (nota != null) {
            nota.setTitulo(notaDetails.getTitulo());
            nota.setContenido(notaDetails.getContenido());
            return notaRepository.save(nota);
        } else {
            return null;
        }
    }

    public boolean deleteNota(Integer id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
