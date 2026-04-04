package org.fab.sisrecruta.servicies;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.entities.PunicaoAplicavelEntity;
import org.fab.sisrecruta.projections.dtos.PunicaoAplicavelDTO;
import org.fab.sisrecruta.projections.dtos.PunicaoDTO;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;
import org.fab.sisrecruta.repositories.PunicaoAplicavelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PunicaoAplicavelService {
    private final PunicaoAplicavelRepository punicaoAplicavelRepository;

    public Collection<PunicaoAplicavelDTO> getPunicaoAplicavelByClassificacao(ClassificacaoPunicaoEnum classificacao) {
    return punicaoAplicavelRepository.findPunicaoAplicavelEntitiesByClassificacao(classificacao)
            .stream()
            .map(PunicaoAplicavelDTO::new)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
