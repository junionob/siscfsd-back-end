package org.fab.sisrecruta.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.projections.dtos.MembroCoordenacaoDTO;
import org.fab.sisrecruta.projections.enums.TipoFuncao;
import org.fab.sisrecruta.projections.records.MembroCoordenacaoRecord;
import org.fab.sisrecruta.servicies.MembroCoordenacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("membro-coordenacao")
@Tag(name = "Coordenação", description = "Gerenciamento dos membros da coordenação")
public class MembroCoordenacaoController {

    @Autowired
    private MembroCoordenacaoService membroCoordenacaoService;

    @PostMapping
    @Operation(summary = "Criar membro da coordenação", description = "Insere um novo membro a coordenação")
    public ResponseEntity<MembroCoordenacaoDTO> createMembroCoordenacao(TipoFuncao funcao, MembroCoordenacaoRecord record){
        return ResponseEntity.ok(membroCoordenacaoService.adicionarMembroCordenacao(record, funcao));
    }

    @GetMapping
    @Operation(summary = "Listar todos membros", description = "Lista todos os membros da coordenação" )
    public ResponseEntity<List<MembroCoordenacaoDTO>> getAllCoordenacao(){
        return ResponseEntity.ok(membroCoordenacaoService.getAllMembrosCoordenacao());
    }
}
