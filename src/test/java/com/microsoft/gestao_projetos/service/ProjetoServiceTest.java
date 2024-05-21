package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.enumeration.StatusProjeto;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.ClienteRepository;
import com.microsoft.gestao_projetos.repositories.ProjetoRepository;
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

public class ProjetoServiceTest {

    @InjectMocks
    private ProjetoService projetoService;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Projeto projeto = new Projeto();
        when(projetoRepository.findAll()).thenReturn(Collections.singletonList(projeto));

        List<Projeto> projetos = projetoService.findAll();
        assertEquals(1, projetos.size());
    }

    @Test
    void testSave() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Teste", "PENDENTE", 1L,  Collections.emptyList());
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        projeto.setStatus(StatusProjeto.valueOf("PENDENTE"));
        projeto.setCliente(cliente);

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        ProjetoResponse response = projetoService.save(projetoDTO);
        assertEquals(1L, response.cliente_id());
        assertEquals("Projeto Teste", response.nome());
    }

    @Test
    void testSaveThrowsException() {
        ProjetoDTO projetoDTO = new ProjetoDTO(1L,"", "PENDENTE", null,  Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> projetoService.save(projetoDTO));
    }

    @Test
    void testUpdate() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Teste", "PENDENTE", 1L, Collections.emptyList());
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        projeto.setStatus(StatusProjeto.valueOf("PENDENTE"));
        projeto.setCliente(cliente);

        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(projeto));
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        ProjetoResponse response = projetoService.update(1L, projetoDTO);
        assertEquals(1L, response.cliente_id());
        assertEquals("Projeto Teste", response.nome());
    }

    @Test
    void testUpdateThrowsException() {
        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "", "PENDENTE", null, Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> projetoService.update(1L, projetoDTO));
    }

    @Test
    void testDelete() {
        when(projetoRepository.existsById(anyLong())).thenReturn(true);

        ResponseEntity<String> response = projetoService.delete(1L);
        assertEquals("Deletado com sucesso", response.getBody());
    }

    @Test
    void testDeleteThrowsException() {
        when(projetoRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> projetoService.delete(1L));
    }
}
