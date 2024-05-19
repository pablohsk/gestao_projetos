package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.AtividadeRepository;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public List<Atividade> findByProjetoId(Long projetoId) {
        return atividadeRepository.findByProjetoId(projetoId);
    }

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public AtividadeResponse save(AtividadeDTO atividade) {
        Atividade atividadeModel = new Atividade();
        atividadeModel.setStatus(atividade.status());
        atividadeModel.setDescricao(atividade.descricao());
        Optional<Projeto> projetosalvo = projetoRepository.findById(atividade.id_projeto());
        atividadeModel.setProjeto(projetosalvo.get());
        Atividade atividadeSalvo = atividadeRepository.save(atividadeModel);
        return new AtividadeResponse(atividadeSalvo.getId(), atividade.descricao(), atividade.status(), atividade.id_projeto());
    }
}
