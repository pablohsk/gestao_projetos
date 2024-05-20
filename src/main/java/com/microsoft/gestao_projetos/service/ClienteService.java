package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<ClienteResponse> save(ClienteDTO clienteDTO) {
        if (clienteDTO.nome() == null || clienteDTO.nome().isEmpty()) {
            throw new IllegalArgumentException("Erro, faltam argumentos para criação");
        }
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        Cliente savedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteResponse(savedCliente.getId(), savedCliente.getNome()));
    }

    public ResponseEntity<ClienteResponse> update(Long id, ClienteDTO clienteDTO) {
        if (clienteDTO.nome() == null || clienteDTO.nome().isEmpty()) {
            throw new IllegalArgumentException("Erro, faltam argumentos para atualização");
        }
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found with id " + id));
        cliente.setNome(clienteDTO.nome());
        Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteResponse(updatedCliente.getId(), updatedCliente.getNome()));
    }


    public ResponseEntity<String> delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente not found with id " + id);
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
