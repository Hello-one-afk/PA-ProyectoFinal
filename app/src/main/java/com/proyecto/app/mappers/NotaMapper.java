package com.proyecto.app.mappers;

import com.proyecto.app.DTOs.NotaDTO;
import com.proyecto.app.models.Nota;

public class NotaMapper {
   
    public static NotaDTO toNotaDTO(Nota nota) {
        NotaDTO notaDTO = new NotaDTO();
        notaDTO.setId(nota.getId());
        notaDTO.setTitulo(nota.getTitulo());
        notaDTO.setContenido(nota.getContenido());
        return notaDTO;
    }

    public static Nota toEntity(NotaDTO notaDTO) {
        Nota nota = new Nota();
        nota.setId(notaDTO.getId());
        nota.setTitulo(notaDTO.getTitulo());
        nota.setContenido(notaDTO.getContenido());
        return nota;
    }
}

