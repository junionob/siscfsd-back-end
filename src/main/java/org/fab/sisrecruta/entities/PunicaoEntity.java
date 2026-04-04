package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

import java.time.LocalDate;

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
    @JoinColumn(name = "ID_RECRUTA")
    private RecrutaEntity recruta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CLASSIFICACAO")
    private ClassificacaoPunicaoEnum classificacao;

    @Column(name = "TX_BREVE_DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "ID_PUNICAO_APLICAVEL")
    private Long idPunicaoAplicada;

    @Column(name = "DT_HORARIO_PUNICAO")
    private LocalDate dtHora;

    @Column(name = "ID_MEMBRO_COORDENACAO")
    private Long idMembroCoordenacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEMBRO_COORDENACAO", referencedColumnName = "ID_MEMBRO_COORDENACAO", insertable = false, updatable = false)
    private MembroCoordenacaoEntity membroCoordenacaoByIdMembroCoordenacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PUNICAO_APLICAVEL", referencedColumnName = "ID_PUNICAO_APLICAVEL", insertable = false, updatable = false)
    private PunicaoAplicavelEntity punicaoAplicavelEntityByIdPunicaoAplicavelEntity;




}
