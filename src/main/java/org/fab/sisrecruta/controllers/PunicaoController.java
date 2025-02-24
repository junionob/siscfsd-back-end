package org.fab.sisrecruta.controllers;

import org.fab.sisrecruta.projections.dtos.PunicaoDTO;
import org.fab.sisrecruta.projections.records.PunicaoRecord;
import org.fab.sisrecruta.servicies.PunicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("punicao")
public class PunicaoController {

    @Autowired
    private PunicaoService punicaoService;

    @PostMapping("criar-by-recruta")
    public ResponseEntity<PunicaoDTO> CriarPunicao(@RequestBody PunicaoRecord record) throws Exception {
        return ResponseEntity.ok(punicaoService.createPunicao(record));
    }
}
