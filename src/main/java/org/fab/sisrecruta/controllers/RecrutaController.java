package org.fab.sisrecruta.controllers;

import org.fab.sisrecruta.projections.dtos.RecrutaDTO;
import org.fab.sisrecruta.servicies.RecrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recruta")
public class RecrutaController {

    @Autowired
    RecrutaService recrutaService;

    @GetMapping
    public ResponseEntity<List<RecrutaDTO>> findAllRecrutas() {
        return ResponseEntity.ok(recrutaService.findAll());
    }

    @PostMapping
    public void cadastrarRecruta(@RequestBody RecrutaDTO dto) {
       recrutaService.cadastrarRecruta(dto);
    }
}
