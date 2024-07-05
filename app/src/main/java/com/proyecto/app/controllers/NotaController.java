package com.proyecto.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/v1/api/notas")
@CrossOrigin(origins = "http://localhost:8080")
public class NotaController {

    @Autowired
    private NotaService notaService;;

    @GetMapping
    public ResponseEntity<List<Nota>> getAllNotas() throws Exception{
        try {
            return ResponseEntity.ok(notaService.getAllNotas());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Nota>> getNotasForUser(@PathVariable("userId") Long id) throws Exception {
        try {
            return ResponseEntity.ok(notaService.getSNotasForUser(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Integer id) throws Exception {
        try {
          return ResponseEntity.ok(notaService.getNotaById(id));  
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) throws Exception {
        try {
            return ResponseEntity.ok(notaService.createNota(nota));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Integer id, @RequestBody Nota notaDetails) throws Exception {
        Nota updatedNota = notaService.updateNota(id, notaDetails);
        if (updatedNota != null) {
            return ResponseEntity.ok(updatedNota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Integer id) throws Exception {
        try {
            notaService.deleteNota(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteByAdmin(@PathVariable Integer noteId) {
        try {
            notaService.deleteNota(noteId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
