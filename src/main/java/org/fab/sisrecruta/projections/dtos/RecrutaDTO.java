package org.fab.sisrecruta.projections.dtos;

import lombok.*;
import org.fab.sisrecruta.entities.RecrutaEntity;

import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecrutaDTO {
    Long id;
    String nmNome;
    String nmGuerra;
    Integer nrNumerica;
    LocalDate dtNascimento;
    TurmaResumeDTO turmaResume;

    public RecrutaDTO(RecrutaEntity entity) {
        this.id = entity.getId();
        this.nmNome = entity.getNmNome();
        this.nmGuerra = entity.getNmGuerra();
        this.nrNumerica = entity.getNrNumerica();
        this.dtNascimento = entity.getDtNascimento();
        this.turmaResume = new TurmaResumeDTO(entity.getTurma() == null ? new RecrutaEntity() : entity);
    }
}
