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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECRUTA")
    private Long id;

    @Column(name = "NM_NOME")
    private String nmNome;

    @Column(name = "NM_GUERRA")
    private String nmGuerra;

    @Column(name = "NR_NUMERICA")
    private Integer nrNumerica;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dtNascimento;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ID_TURMA")
    private TurmaEntity turma;

    @OneToMany(mappedBy = "recruta", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<PunicaoEntity> punicao;



}
