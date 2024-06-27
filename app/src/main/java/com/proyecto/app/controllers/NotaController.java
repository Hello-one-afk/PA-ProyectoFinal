package com.proyecto.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.app.models.Nota;
import com.proyecto.app.services.NotaService;

@Controller
@RequestMapping("api/notas")
public class NotaController {

    private NotaService notaService;

    @GetMapping
    public ResponseEntity<?> getNotas() throws Exception {
        try {
            return ResponseEntity.ok(notaService.getAllNotas());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping
    public ResponseEntity<?> saveNotas(@RequestBody Nota nota) throws Exception {
        try {
            return ResponseEntity.ok(notaService.saveNota(nota));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
