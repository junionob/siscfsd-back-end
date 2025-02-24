package org.fab.sisrecruta.controllers;

import org.fab.sisrecruta.projections.dtos.TurmaDTO;
import org.fab.sisrecruta.projections.records.GritoGuerraRecord;
import org.fab.sisrecruta.projections.records.TurmaRecord;
import org.fab.sisrecruta.repositories.TurmaRepository;
import org.fab.sisrecruta.servicies.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaService service;
    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping
    public ResponseEntity<TurmaDTO> createTurma(@RequestBody TurmaRecord record){
        return ResponseEntity.ok(service.createTurma(record));
    }

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> getAllTurmas(){
        return ResponseEntity.ok(service.getAllTurmas());
    }

    @PutMapping
    public ResponseEntity<TurmaDTO> setGritoGuerra(@RequestBody GritoGuerraRecord record){
        return ResponseEntity.ok(service.setGritoGuerra(record.idTurma(), record.txGritoGuerra()));
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<TurmaDTO> finalizarTurma(@PathVariable Long id){
        return ResponseEntity.ok(service.fecharTurma(id));
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id){
        service.deleteTurmaAbertaById(id);
    }
}
