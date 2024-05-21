package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Cliente cliente = new Cliente();
        when(clienteRepository.findAll()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = clienteService.findAll();
        assertEquals(1, clientes.size());
    }

    @Test
    void testSave() {
        ClienteDTO clienteDTO = new ClienteDTO("Cliente Teste");
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteResponse response = clienteService.save(clienteDTO).getBody();
        assertEquals(1L, response.id());
        assertEquals("Cliente Teste", response.nome());
    }

    @Test
    void testSaveThrowsException() {
        ClienteDTO clienteDTO = new ClienteDTO("");
        assertThrows(IllegalArgumentException.class, () -> clienteService.save(clienteDTO));
    }

    @Test
    void testUpdate() {
        ClienteDTO clienteDTO = new ClienteDTO("Cliente Teste");
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteResponse response = clienteService.update(1L, clienteDTO).getBody();
        assertEquals(1L, response.id());
        assertEquals("Cliente Teste", response.nome());
    }

    @Test
    void testUpdateThrowsException() {
        ClienteDTO clienteDTO = new ClienteDTO("");
        assertThrows(IllegalArgumentException.class, () -> clienteService.update(1L, clienteDTO));
    }

    @Test
    void testDelete() {
        when(clienteRepository.existsById(anyLong())).thenReturn(true);

        ResponseEntity<String> response = clienteService.delete(1L);
        assertEquals("Deletado com sucesso", response.getBody());
    }

    @Test
    void testDeleteThrowsException() {
        when(clienteRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> clienteService.delete(1L));
    }
}
