package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> getAllProjetos() {
        return projetoService.findAll();
    }

    @PostMapping
    public ResponseEntity<ProjetoResponse> createProjeto(@RequestBody ProjetoDTO projetoDTO) {
        ProjetoResponse response = projetoService.save(projetoDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponse> updateProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDTO) {
        ProjetoResponse response = projetoService.update(id, projetoDTO);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjeto(@PathVariable Long id) {
        return projetoService.delete(id);
    }
}
