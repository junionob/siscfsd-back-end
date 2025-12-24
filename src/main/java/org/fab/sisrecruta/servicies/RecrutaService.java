package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.PessoaEntity;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.entities.TurmaEntity;
import org.fab.sisrecruta.projections.dtos.RecrutaDTO;
import org.fab.sisrecruta.repositories.RecrutaRepository;
import org.fab.sisrecruta.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecrutaService {

    private final RecrutaRepository recrutaRepository;
    private final TurmaRepository turmaRepository;
    private final PessoaService pessoaService;

    @Autowired
    public RecrutaService(RecrutaRepository recrutaRepository, TurmaRepository turmaRepository, PessoaService pessoaService) {
        this.recrutaRepository = recrutaRepository;
        this.turmaRepository = turmaRepository;
        this.pessoaService = pessoaService;
    }

    public List<RecrutaDTO> findAll() {
        List<RecrutaEntity> recrutas = recrutaRepository.findAll();
        return recrutas.stream()
                .map(RecrutaDTO::new)
                .sorted(Comparator
                        .comparing(RecrutaDTO::getNrNumerica,
                                Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(RecrutaDTO::getNmNome, Comparator.nullsLast(String::compareTo)))
                        .collect(Collectors.toList());
    }

    @Transactional
    public void cadastrarRecruta(RecrutaDTO dto) {
        TurmaEntity turma = turmaRepository.findById(dto.getTurmaResume().getId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        PessoaEntity pessoa = PessoaEntity.builder()
                .nmNome(dto.getNmNome().toUpperCase())
                .nmGuerra(dto.getNmGuerra().toUpperCase())
                .dtNascimento(dto.getDtNascimento())
                .build();
        pessoaService.cretePessoa(pessoa);


        RecrutaEntity recrutaEntity = RecrutaEntity.builder()
                .id(pessoa.getId())
                .nrNumerica(null)
                .idTurma(turma.getIdTurma())
                .build();
        recrutaRepository.save(recrutaEntity);

    }

    @Transactional
    public Boolean setNumericaPorIdade(TurmaEntity turma) {

        List<RecrutaEntity> recrutas = recrutaRepository.findByIdTurma(turma.getIdTurma());
        int sum = 1;
        for (RecrutaEntity rec : recrutas) {
            rec.setNrNumerica(sum);
            sum++;
            recrutaRepository.save(rec);
        }

        List<RecrutaEntity> recrutasComNumerica = recrutaRepository.findByIdTurma(turma.getIdTurma());

        var rec = recrutasComNumerica.stream().filter(r -> r.getNrNumerica() == null).toList();
        return rec.isEmpty();
    }

    @Transactional(readOnly = true)
    public RecrutaEntity findById(Long id) throws Exception {
        return recrutaRepository.findById(id).orElseThrow(() -> new Exception("Recruta não encontrado com o id: " + id));
    }
}
