package org.fab.sisrecruta.controllers;

import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.projections.dtos.RecrutaDTO;
import org.fab.sisrecruta.servicies.RecrutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recruta")
@RequiredArgsConstructor
public class RecrutaController {

    private final RecrutaService recrutaService;

    @GetMapping
    public ResponseEntity<List<RecrutaDTO>> findAll() {
        return ResponseEntity.ok(recrutaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RecrutaDTO dto) {
        recrutaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecrutaDTO> getById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(new RecrutaDTO(recrutaService.findById(id)));
    }
}
