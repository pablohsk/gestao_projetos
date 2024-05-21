package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atividades")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<AtividadeResponse> getAllAtividades() {
        List<Atividade> atividades = atividadeService.findAll();
        return atividades.stream()
                .map(atividade -> new AtividadeResponse(
                        atividade.getId(),
                        atividade.getDescricao(),
                        atividade.getStatus().toString(),
                        atividade.getProjeto().getId()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AtividadeResponse> createAtividade(@RequestBody AtividadeDTO atividadeDTO) {
        AtividadeResponse response = atividadeService.save(atividadeDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeResponse> updateAtividade(@PathVariable Long id, @RequestBody AtividadeDTO atividadeDTO) {
        AtividadeResponse response = atividadeService.update(id, atividadeDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAtividade(@PathVariable Long id) {
        return atividadeService.delete(id);
    }
}
