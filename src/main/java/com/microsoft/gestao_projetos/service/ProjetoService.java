package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.enumeration.StatusProjeto;
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
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public ProjetoResponse save(ProjetoDTO projeto) {
        if (projeto.nome() == null || projeto.nome().isEmpty() || projeto.status() == null || projeto.cliente_id() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para criação");
        }

        Projeto projetoModel = new Projeto();
        projetoModel.setNome(projeto.nome());
        projetoModel.setStatus(StatusProjeto.valueOf(projeto.status())); // Converta a String para o enum StatusProjeto
        Cliente cliente = clienteRepository.findById(projeto.cliente_id())
                .orElseThrow(() -> new NoSuchElementException("Nenhum cliente foi encontrado no sistema com o ID: " + projeto.cliente_id() + " ."));
        projetoModel.setCliente(cliente);

        Projeto projetoSalvo = projetoRepository.save(projetoModel);

        return new ProjetoResponse(
                projetoSalvo.getId(),
                projetoSalvo.getNome(),
                projetoSalvo.getStatus().toString(),
                projetoSalvo.getCliente().getId(),
                List.of()
        );
    }

    public ProjetoResponse update(Long id, ProjetoDTO projeto) {
        if (projeto.nome() == null || projeto.nome().isEmpty() || projeto.status() == null || projeto.cliente_id() == null) {
            throw new IllegalArgumentException("Erro, faltam argumentos para atualização");
        }

        Projeto existingProjeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto not found with id " + id));

        Cliente cliente = clienteRepository.findById(projeto.cliente_id())
                .orElseThrow(() -> new NoSuchElementException("Nenhum cliente foi encontrado no sistema com o ID: " + projeto.cliente_id() + " ."));

        existingProjeto.setCliente(cliente);
        existingProjeto.setNome(projeto.nome());
        existingProjeto.setStatus(StatusProjeto.valueOf(projeto.status())); // Converta a String para o enum StatusProjeto

        Projeto projetoSalvo = projetoRepository.save(existingProjeto);

        return new ProjetoResponse(
                projetoSalvo.getId(),
                projetoSalvo.getNome(),
                projetoSalvo.getStatus().toString(),
                projetoSalvo.getCliente().getId(),
                projetoSalvo.getAtividades().stream()
                        .map(atividade -> new AtividadeResponse(
                                atividade.getId(),
                                atividade.getDescricao(),
                                atividade.getStatus().toString(),
                                atividade.getProjeto().getId()
                        ))
                        .collect(Collectors.toList())
        );
    }

    public List<ProjetoResponse> getAllProjetosWithAtividades() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos.stream()
                .map(projeto -> new ProjetoResponse(
                        projeto.getId(),
                        projeto.getNome(),
                        projeto.getStatus().toString(),
                        projeto.getCliente().getId(),
                        projeto.getAtividades().stream()
                                .map(atividade -> new AtividadeResponse(
                                        atividade.getId(),
                                        atividade.getDescricao(),
                                        atividade.getStatus().toString(),
                                        atividade.getProjeto().getId()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> delete(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto not found with id " + id);
        }
        projetoRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}