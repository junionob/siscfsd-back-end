package org.fab.sisrecruta.projections.dtos;

import jakarta.persistence.OneToMany;
import lombok.*;
import org.fab.sisrecruta.entities.PessoaEntity;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.entities.TurmaEntity;

import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecrutaDTO {
    Long id;
    String nmNome;
    String nmGuerra;
    String nrNumerica;
    LocalDate dtNascimento;
    TurmaResumeDTO turmaResume;
    Character sexo;
    String nrCpf;

    public RecrutaDTO(RecrutaEntity entity) {
        this.id = entity.getId();
        this.nrNumerica = entity.getNrNumerica() != null ? entity.getNrNumerica().toString() : "Não definido" ;

        PessoaEntity pessoa = entity.getPessoaByIdPessoa();
        this.nmNome = pessoa.getNmNome().toUpperCase();
        this.nmGuerra = pessoa.getNmGuerra().toUpperCase();
        this.dtNascimento = entity.getPessoaByIdPessoa().getDtNascimento();
        this.sexo = pessoa.getSexo();
        this.nrCpf = pessoa.getNrCpf();

        TurmaEntity turma = entity.getTurmaByIdTurma();
        this.turmaResume = new TurmaResumeDTO(turma != null ? turma : new TurmaEntity());
    }
}
