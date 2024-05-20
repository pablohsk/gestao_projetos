package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public List<Projeto> findByClienteId(Long clienteId) {
        return projetoRepository.findByClienteId(clienteId);
    }

    public ProjetoResponse save(ProjetoDTO projeto) {
        if (projeto.nome() == null || projeto.nome().isEmpty() || projeto.status() == null || projeto.id_client() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para criação");
        }
        Projeto projetoModel = new Projeto();
        projetoModel.setNome(projeto.nome());
        projetoModel.setStatus(projeto.status());
        Cliente cliente = clienteRepository.findById(projeto.id_client()).orElseThrow(() -> new NoSuchElementException("Nenhum cliente foi encontrada no sistema com o ID: " + projeto.id_client() + " ."));
        projetoModel.setCliente(cliente);
        Projeto projetoSalvo = projetoRepository.save(projetoModel);
        return new ProjetoResponse(projetoSalvo.getId(), projetoSalvo.getNome(), projetoSalvo.getStatus(), projetoSalvo.getCliente().getId(), projetoSalvo.getCliente().getNome());
    }

    public ProjetoResponse update(Long id, ProjetoDTO projeto) {
        if (projeto.nome() == null || projeto.nome().isEmpty() || projeto.status() == null || projeto.id_client() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para atualização");
        }
        Projeto existingProjeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto not found with id " + id));

        Cliente cliente = clienteRepository.findById(projeto.id_client()).
                orElseThrow(() -> new NoSuchElementException("Nenhum cliente foi encontrada no sistema com o ID: " + projeto.id_client() + " ."));

        existingProjeto.setCliente(cliente);
        existingProjeto.setNome(projeto.nome());
        existingProjeto.setStatus(projeto.status());

        Projeto projetoSalvo = projetoRepository.save(existingProjeto);

        return new ProjetoResponse(projetoSalvo.getId(), projetoSalvo.getNome(), projetoSalvo.getStatus(), projetoSalvo.getCliente().getId(), projetoSalvo.getCliente().getNome());
    }

    public ResponseEntity<String> delete(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto not found with id " + id);
        }
        projetoRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
