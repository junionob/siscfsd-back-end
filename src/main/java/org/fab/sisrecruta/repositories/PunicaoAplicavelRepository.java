package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.PunicaoAplicavelEntity;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PunicaoAplicavelRepository extends JpaRepository<PunicaoAplicavelEntity, Long> {

    Collection<PunicaoAplicavelEntity> findPunicaoAplicavelEntitiesByClassificacao(ClassificacaoPunicaoEnum classificacao);
}
