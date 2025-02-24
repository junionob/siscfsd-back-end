package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.entities.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RecrutaRepository extends JpaRepository<RecrutaEntity, Long> {

    List<RecrutaEntity> findByTurmaOrderByDtNascimentoAsc(TurmaEntity turma);
}
