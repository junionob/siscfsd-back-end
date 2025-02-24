package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.TurmaEntity;
import org.fab.sisrecruta.projections.enums.SituacaoTurma;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TurmaDTO {
    private Long idTurma;
    private String nmTurma;
    private String txGritoGuerra;
    private LocalDate dtIncorporacao;
    private LocalDate dtFormatura;
    private SituacaoTurma situacaoTurma;

    public TurmaDTO(TurmaEntity entity) {
        idTurma = entity.getIdTurma();
        nmTurma = entity.getNmTurma();
        txGritoGuerra = entity.getTxGritoGuerra();
        dtIncorporacao = entity.getDtIncorporacao();
        dtFormatura = entity.getDtFormatura();
        situacaoTurma = entity.getSituacaoTurma();
    }
}
