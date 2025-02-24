package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "T_PUNICAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PunicaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PUNICAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_RECRUTA", nullable = true)
    private RecrutaEntity recruta;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "ID_CLASSIFICACAO")
    private ClassificacaoPunicaoEnum classificacao;

    @Column(name = "TX_BREVE_DESCRICAO", length = 300, nullable = true)
    private String descricao;

    @Column(name = "TX_PUNICAO", length = 100, nullable = true)
    private String punicao;

    @Column(name = "DT_HORARIO_PUNICAO")
    private LocalDate dtHora;

    @ManyToOne
    @JoinColumn(name = "ID_MEMBRO_COORDENACAO")
    private MembroCoordenacaoEntity membroCoordenacao;

}
