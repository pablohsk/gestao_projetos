package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testGetAllClientes() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");
        List<Cliente> clientes = Collections.singletonList(cliente);
        when(clienteService.findAll()).thenReturn(clientes);

        List<ClienteResponse> result = clienteController.getAllClientes();

        assertEquals(1, result.size());
        assertEquals("Cliente Teste", result.get(0).nome());
        verify(clienteService, times(1)).findAll();
    }

    @Test
    void testCreateCliente() {
        ClienteDTO clienteDTO = new ClienteDTO(1L, "Cliente Teste");
        ClienteResponse clienteResponse = new ClienteResponse(1L, "Cliente Teste");
        when(clienteService.save(clienteDTO)).thenReturn(ResponseEntity.ok(clienteResponse));

        ResponseEntity<ClienteResponse> response = clienteController.createCliente(clienteDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clienteResponse, response.getBody());
        verify(clienteService, times(1)).save(clienteDTO);
    }

    @Test
    void testUpdateCliente() {
        Long id = 1L;
        ClienteDTO clienteDTO = new ClienteDTO(1L, "Cliente Atualizado");
        ClienteResponse clienteResponse = new ClienteResponse(id, "Cliente Atualizado");
        when(clienteService.update(id, clienteDTO)).thenReturn(ResponseEntity.ok(clienteResponse));

        ResponseEntity<ClienteResponse> response = clienteController.updateCliente(id, clienteDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clienteResponse, response.getBody());
        verify(clienteService, times(1)).update(id, clienteDTO);
    }

    @Test
    void testDeleteCliente() {
        Long id = 1L;
        ResponseEntity<String> response = ResponseEntity.ok("Deletado com sucesso");
        when(clienteService.delete(id)).thenReturn(response);

        ResponseEntity<String> result = clienteController.deleteCliente(id);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Deletado com sucesso", result.getBody());
        verify(clienteService, times(1)).delete(id);
    }
}