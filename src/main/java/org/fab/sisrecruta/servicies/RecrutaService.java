package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.entities.TurmaEntity;
import org.fab.sisrecruta.projections.dtos.RecrutaDTO;
import org.fab.sisrecruta.repositories.RecrutaRepository;
import org.fab.sisrecruta.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecrutaService {

    @Autowired
    RecrutaRepository recrutaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public List<RecrutaDTO> findAll() {
        List<RecrutaEntity> recrutas = recrutaRepository.findAll();
        return recrutas.stream().map(RecrutaDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public RecrutaDTO cadastrarRecruta(RecrutaDTO dto) {
        TurmaEntity turma = turmaRepository.findById(dto.getTurmaResume().getId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        RecrutaEntity recrutaEntity = RecrutaEntity.builder()
                .nmNome(dto.getNmNome())
                .nmGuerra(dto.getNmGuerra())
                .nrNumerica(null)
                .turma(turma)
                .dtNascimento(dto.getDtNascimento())
                .build();
        recrutaRepository.save(recrutaEntity);

        return new RecrutaDTO(recrutaEntity);
    }

    @Transactional
    public Boolean setNumericaPorIdade(TurmaEntity turma) {
        List<RecrutaEntity> recrutas = recrutaRepository.findByTurmaOrderByDtNascimentoAsc(turma);
        int sum = 1;
        for (RecrutaEntity rec : recrutas) {
            rec.setNrNumerica(sum);
            sum++;
            recrutaRepository.save(rec);
        }

        List<RecrutaEntity> recrutasComNumerica = recrutaRepository.findByTurmaOrderByDtNascimentoAsc(turma);

        var rec = recrutasComNumerica.stream().filter(r -> r.getNrNumerica() == null).collect(Collectors.toList());
        if(rec.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = true)
    public RecrutaEntity findById(Long id) throws Exception {
        return recrutaRepository.findById(id).orElseThrow(() -> new Exception("Recruta não encontrado com o id: " + id));
    }
}
