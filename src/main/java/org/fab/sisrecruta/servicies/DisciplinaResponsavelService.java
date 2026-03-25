package org.fab.sisrecruta.servicies;

import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.entities.DisciplinaResponsavelEntity;
import org.fab.sisrecruta.projections.dtos.DisciplinaResponsavelDTO;
import org.fab.sisrecruta.repositories.DisciplinaResponsavelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisciplinaResponsavelService {

    private final DisciplinaResponsavelRepository disciplinaResponsavelRepository;

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
