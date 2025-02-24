package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.projections.enums.TipoFuncao;

@Table(name = "T_DISCIPLINA_RESPONSAVEL")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisciplinaResponsavelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID__DISCIPLINA", nullable = true)
    private DisciplinaEntity disciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEMBRO_COORDENACAO", nullable = true)
    private MembroCoordenacaoEntity membroCoordenacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_FUNCAO", nullable = true)
    TipoFuncao tipoFuncao;
}
