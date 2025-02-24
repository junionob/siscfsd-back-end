package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.DisciplinaResponsavelEntity;
import org.fab.sisrecruta.projections.dtos.DisciplinaResponsavelDTO;
import org.fab.sisrecruta.repositories.DisciplinaRepository;
import org.fab.sisrecruta.repositories.DisciplinaResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisciplinaResponsavelService {

    @Autowired
    private DisciplinaResponsavelRepository disciplinaResponsavelRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional
    public void atribuirInstrutorToDisciplina(DisciplinaResponsavelDTO dto){
        DisciplinaResponsavelEntity disciplinaResponsavel = DisciplinaResponsavelEntity.builder()
                .tipoFuncao(dto.getTipoFuncao())
                .disciplina(dto.getDisciplina())
                .membroCoordenacao(dto.getMembroCoordenacao())
                .build();

        disciplinaResponsavelRepository.save(disciplinaResponsavel);
    }
}
