package org.fab.sisrecruta.controllers;

import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.projections.dtos.PunicaoAplicavelDTO;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;
import org.fab.sisrecruta.servicies.PunicaoAplicavelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("punicao-aplicavel")
@RequiredArgsConstructor
public class PunicaoAplicavelController {

    private final PunicaoAplicavelService service;

    @GetMapping("/{classificacao}")
    public ResponseEntity<Collection<PunicaoAplicavelDTO>> findAllByClassificacao(@PathVariable ClassificacaoPunicaoEnum classificacao) {
        return ResponseEntity.ok(service.getPunicaoAplicavelByClassificacao(classificacao));
    }
}
