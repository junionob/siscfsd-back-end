package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.DisciplinaResponsavelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaResponsavelRepository extends JpaRepository<DisciplinaResponsavelEntity, Long> {
}
