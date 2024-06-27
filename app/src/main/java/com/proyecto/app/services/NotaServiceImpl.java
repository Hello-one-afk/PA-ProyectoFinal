package com.proyecto.app.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.proyecto.app.DTOs.NotaDTO;
import com.proyecto.app.mappers.NotaMapper;
import com.proyecto.app.models.Nota;
import com.proyecto.app.repository.NotaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Override
    public List<NotaDTO> getAllNotas() throws Exception {
        try {
            List<Nota> notas = notaRepository.findAll();
            return notas.stream()
                    .map(NotaMapper::toNotaDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching notas: " + e.getMessage());
        }
    }

    @Override
    public void deleteNota(Integer id) throws Exception {
        try {
            if (notaRepository.existsById(id)) {
                notaRepository.deleteById(id);
            } else {
                throw new Exception("Nota not found: " + id);
            }
        } catch (DataAccessException e) {
            throw new Exception("Error deleting nota: " + e.getMessage());
        }
    }
}

