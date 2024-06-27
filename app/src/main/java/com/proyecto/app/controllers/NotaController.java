package com.proyecto.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.app.models.Nota;
import com.proyecto.app.services.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Integer id) {
        Nota nota = notaService.getNotaById(id);
        if (nota != null) {
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.createNota(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Integer id, @RequestBody Nota notaDetails) {
        Nota updatedNota = notaService.updateNota(id, notaDetails);
        if (updatedNota != null) {
            return ResponseEntity.ok(updatedNota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Integer id) {
        if (notaService.deleteNota(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
