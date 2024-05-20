package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.AtividadeRepository;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public AtividadeResponse save(AtividadeDTO atividadeDTO) {
        if (atividadeDTO.descricao() == null || atividadeDTO.descricao().isEmpty() || atividadeDTO.id_projeto() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para criação");
        }
        Atividade atividade = new Atividade();
        atividade.setDescricao(atividadeDTO.descricao());
        atividade.setStatus(atividadeDTO.status());
        Projeto projeto = projetoRepository.findById(atividadeDTO.id_projeto())
                .orElseThrow(() -> new ResourceNotFoundException("Projeto not found with id " + atividadeDTO.id_projeto()));
        atividade.setProjeto(projeto);
        Atividade savedAtividade = atividadeRepository.save(atividade);
        return new AtividadeResponse(savedAtividade.getId(), savedAtividade.getDescricao(), savedAtividade.getStatus().name(), savedAtividade.getProjeto().getId());
    }

    public AtividadeResponse update(Long id, AtividadeDTO atividadeDTO) {
        if (atividadeDTO.descricao() == null || atividadeDTO.descricao().isEmpty() || atividadeDTO.id_projeto() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para atualização");
        }
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade not found with id " + id));
        atividade.setDescricao(atividadeDTO.descricao());
        atividade.setStatus(atividadeDTO.status());
        Projeto projeto = projetoRepository.findById(atividadeDTO.id_projeto())
                .orElseThrow(() -> new ResourceNotFoundException("Projeto not found with id " + atividadeDTO.id_projeto()));
        atividade.setProjeto(projeto);
        Atividade updatedAtividade = atividadeRepository.save(atividade);
        return new AtividadeResponse(updatedAtividade.getId(), updatedAtividade.getDescricao(), updatedAtividade.getStatus().name(), updatedAtividade.getProjeto().getId());
    }

    public ResponseEntity<String> delete(Long id) {
        if (!atividadeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Atividade not found with id " + id);
        }
        atividadeRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
