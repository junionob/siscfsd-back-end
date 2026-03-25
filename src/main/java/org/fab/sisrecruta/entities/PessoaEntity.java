package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    @Basic
    Long id;

    @Column(name = "NM_NOME", length = 150, nullable = false)
    @Basic
    String nmNome;

    @Column(name = "NM_GUERRA", length = 20, nullable = false)
    @Basic
    private String nmGuerra;

    @Column(name = "NR_CPF", unique = true, length = 11)
    @Basic
    private String nrCpf;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    @Basic
    private LocalDate dtNascimento;

    @Column(name = "SG_SEXO", nullable = false, length = 1)
    @Basic
    private Character sexo;
}
