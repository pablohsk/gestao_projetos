package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @PostMapping
    public ClienteResponse createCliente(@RequestBody ClienteDTO cliente) {
        return clienteService.save(cliente);
    }
}