package org.fab.sisrecruta.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.projections.dtos.TurmaDTO;
import org.fab.sisrecruta.projections.records.TurmaRecord;
import org.fab.sisrecruta.servicies.TurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turma")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService service;

    @PostMapping
    public ResponseEntity<TurmaDTO> create(@RequestBody  TurmaRecord record){
        return ResponseEntity.ok(service.createTurma(record));
    }

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<TurmaDTO> finish(@PathVariable Long id){
        return ResponseEntity.ok(service.closeTurma(id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id){
        service.deleteTurmaAbertaById(id);
    }
}
