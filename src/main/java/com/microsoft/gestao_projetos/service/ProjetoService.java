package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Projeto projetosalvo = new Projeto();
        projetosalvo.setNome(projeto.nome());
        projetosalvo.setStatus(projeto.status());
        Optional<Cliente> clientesalvo = clienteRepository.findById(projeto.id_client());
        projetosalvo.setCliente(clientesalvo.get());
        Projeto objetoProjeto = projetoRepository.save(projetosalvo);
        return new ProjetoResponse(objetoProjeto.getId(), projeto.nome(), projeto.status(), projeto.id_client(), clientesalvo.get().getNome());
    }
}