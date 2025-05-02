package org.fab.sisrecruta.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.fab.sisrecruta.entities.DisciplinaEntity;
import org.fab.sisrecruta.projections.enums.TipoFuncao;
import org.fab.sisrecruta.servicies.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplina")
@Tag(name = "Disciplina", description = "Gerenciamento das disciplinas do curso")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    @Operation(summary = "Criar disciplina do curso", description = "Cria uma nova disciplina")
    public ResponseEntity<DisciplinaEntity> createDisciplina(String nome, Long cargaHoraria){
        return ResponseEntity.ok(disciplinaService.createDisciplina(nome, cargaHoraria));
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Lista todas disciplinas do curso")
    public ResponseEntity<List<DisciplinaEntity>> findAll(){
        return ResponseEntity.ok(disciplinaService.findAllDisciplinas());
    }

    @PostMapping("instrutor-disciplina")
    @Operation(summary = "Atribuir instrutor da disciplina", description = "Seta um instrutor na disciplina")
    public void setInstrutorToDisciplina(Long idMembroCoordenacao, Long idDisciplina){
        disciplinaService.setInstrutorToDisciplina(idMembroCoordenacao, idDisciplina);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar Matéria", description = "Deleta uma Disciplina")
    public ResponseEntity deleteDisciplina(@PathVariable Long id){
        disciplinaService.deleteDisciplinaById(id);
        return ResponseEntity.ok().build();
    }
}
