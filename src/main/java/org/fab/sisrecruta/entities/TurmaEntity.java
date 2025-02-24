package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.projections.enums.SituacaoTurma;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_TURMA")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TURMA")
    private Long idTurma;

    @Column(name = "NM_TURMA")
    private String nmTurma;

    @Column(name = "TX_GRITO_GUERRA", length = 1000)
    private String txGritoGuerra;

    @Column(name = "DT_INCORPORACAO")
    private LocalDate dtIncorporacao;

    @Column(name = "DT_FORMATURA")
    private LocalDate dtFormatura;

    @OneToMany(mappedBy = "turma")
    private List<RecrutaEntity> recrutas;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "ID_SITUACAO_TURMA")
    private SituacaoTurma situacaoTurma;

}
