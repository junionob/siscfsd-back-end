package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "T_PUNICAO_APLICAVEL")
public class PunicaoAplicavelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PUNICAO_APLICAVEL")
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CLASSIFICACAO", nullable = false)
    private ClassificacaoPunicaoEnum classificacao;

    @Column(name = "TX_PUNICAO_APLICAVEL", nullable = false, length = 100)
    private String txPunicaoAplicavel;
}
