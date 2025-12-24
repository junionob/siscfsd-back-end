package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
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

    @Column(name = "NM_NOME", length = 50, nullable = false)
    @Basic
    String nmNome;

    @Column(name = "NM_GUERRA")
    @Basic
    private String nmGuerra;

    @Column(name = "NR_CPF")
    @Basic
    private String nrCpf;

    @Column(name = "DT_NASCIMENTO")
    @Basic
    private LocalDate dtNascimento;
}
