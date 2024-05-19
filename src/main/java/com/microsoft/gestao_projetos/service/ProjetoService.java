package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public List<Projeto> findByClienteId(Long clienteId) {
        return projetoRepository.findByClienteId(clienteId);
    }

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
}