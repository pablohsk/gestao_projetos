package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> getAllAtividades() {
        return atividadeService.findAll();
    }

    @GetMapping("/projeto/{projetoId}")
    public List<Atividade> getAtividadesByProjeto(@PathVariable Long projetoId) {
        return atividadeService.findByProjetoId(projetoId);
    }

    @PostMapping
    public AtividadeResponse createAtividade(@RequestBody AtividadeDTO atividade) {
        return atividadeService.save(atividade);
    }
}