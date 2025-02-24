package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {
}
