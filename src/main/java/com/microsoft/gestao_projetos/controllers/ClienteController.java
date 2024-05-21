package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return clientes.stream()
                .map(cliente -> new ClienteResponse(cliente.getId(), cliente.getNome()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.update(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        return clienteService.delete(id);
    }
}
