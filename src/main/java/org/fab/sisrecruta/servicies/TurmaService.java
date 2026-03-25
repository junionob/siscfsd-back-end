package org.fab.sisrecruta.servicies;

import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.entities.TurmaEntity;
import org.fab.sisrecruta.projections.dtos.TurmaDTO;
import org.fab.sisrecruta.projections.enums.SituacaoTurma;
import org.fab.sisrecruta.projections.records.TurmaRecord;
import org.fab.sisrecruta.repositories.TurmaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final RecrutaService recrutaService;

    @Transactional
    public TurmaDTO createTurma(TurmaRecord record) {
        TurmaEntity turma = TurmaEntity.builder()
                .nmTurma(record.nome())
                .dtIncorporacao(record.dtIncorporacao())
                .dtFormatura(record.dtFormatura())
                .situacaoTurma(SituacaoTurma.ABERTA)
                .build();
        turmaRepository.save(turma);

        return new TurmaDTO(turma);
    }

    @Transactional(readOnly = true)
    public List<TurmaDTO> getAll() {
        List<TurmaEntity> turmas = turmaRepository.findAll();
        return turmas.stream().map(t -> {
         int qtd =  recrutaService.getAmountByIdTurma(t.getIdTurma());
         TurmaDTO turma = new TurmaDTO(t);
         turma.setQtdAlocados(qtd);
         return turma;
        }).toList();
    }


    @Transactional
    public TurmaDTO closeTurma(Long idTurma) {
        TurmaEntity turma = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));

        Boolean allWithNrNumerica = recrutaService.setNumericaPorIdade(turma);
        if (allWithNrNumerica) {
            turma.setSituacaoTurma(SituacaoTurma.FECHADA);
            turmaRepository.save(turma);
        } else {
            throw new RuntimeException("Não foi possível finalizar o Turma!");
        }
        return new TurmaDTO(turma);
    }

    @Transactional
    public void deleteTurmaAbertaById(Long id) {
        TurmaEntity turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));
        if (turma.getSituacaoTurma() == SituacaoTurma.ABERTA) turmaRepository.delete(turma);
        else {
            throw new RuntimeException("Não foi possivel deletar a Turma!");
        }
    }
}
