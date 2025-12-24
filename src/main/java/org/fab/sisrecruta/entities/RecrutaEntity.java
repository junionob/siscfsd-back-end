package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_RECRUTA")
public class RecrutaEntity {

    @Id
    @Column(name = "ID_PESSOA")
    @Basic
    private Long id;

    @Column(name = "ID_TURMA")
    @Basic
    private Long idTurma;

    @Column(name = "NR_NUMERICA")
    @Basic
    private Integer nrNumerica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA",  insertable = false, updatable = false)
    private PessoaEntity pessoaByIdPessoa;

    @OneToMany(mappedBy = "recruta", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<PunicaoEntity> punicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TURMA", referencedColumnName = "ID_TURMA", insertable = false, updatable = false)
    private TurmaEntity turmaByIdTurma;


}
