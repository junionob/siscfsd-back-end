package org.fab.sisrecruta.servicies;

import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.entities.PessoaEntity;
import org.fab.sisrecruta.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public void cretePessoa(PessoaEntity pessoa) {
        pessoaRepository.save(pessoa);
    }
}
