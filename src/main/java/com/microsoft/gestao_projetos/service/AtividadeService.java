package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public List<Atividade> findByProjetoId(Long projetoId) {
        return atividadeRepository.findByProjetoId(projetoId);
    }

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
}
