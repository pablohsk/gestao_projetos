package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/cliente/{clienteId}")
    public List<Projeto> getProjetosByCliente(@PathVariable Long clienteId) {
        return projetoService.findByClienteId(clienteId);
    }

    @PostMapping
    public Projeto createProjeto(@RequestBody Projeto projeto) {
        return projetoService.save(projeto);
    }

}