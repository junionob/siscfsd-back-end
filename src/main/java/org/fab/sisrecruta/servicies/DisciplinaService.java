package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.DisciplinaEntity;
import org.fab.sisrecruta.entities.DisciplinaResponsavelEntity;
import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.projections.dtos.DisciplinaResponsavelDTO;
import org.fab.sisrecruta.projections.enums.TipoFuncao;
import org.fab.sisrecruta.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private MembroCoordenacaoService membroCoordenacaoService;

    @Autowired
    private DisciplinaResponsavelService disciplinaResponsavelService;

    @Transactional
    public DisciplinaEntity createDisciplina(String nome, Long cargaHoraria) {
        DisciplinaEntity disciplina = DisciplinaEntity.builder()
                .nmMateria(nome.toUpperCase())
                .cargaHorario(cargaHoraria)
                .build();
        disciplinaRepository.save(disciplina);

        return disciplina;
    }

    @Transactional
    public List<DisciplinaEntity> findAllDisciplinas() {
        return disciplinaRepository.findAll();
    }


    @Transactional
    public void setInstrutorToDisciplina(Long idMembroCoordenacao, Long idDisciplina) {
        DisciplinaEntity disciplina = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Disciplina não cadastrada"));

        MembroCoordenacaoEntity membroCoordenacao = membroCoordenacaoService.findById(idMembroCoordenacao);

        DisciplinaResponsavelDTO dto = DisciplinaResponsavelDTO.builder()
                .tipoFuncao(TipoFuncao.INSTRUTOR)
                .disciplina(disciplina)
                .membroCoordenacao(membroCoordenacao)
                .build();

        disciplinaResponsavelService.atribuirInstrutorToDisciplina(dto);

    }
}