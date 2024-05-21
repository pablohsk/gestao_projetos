package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.service.ProjetoService;
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
public class ProjetoControllerTest {

    @Mock
    private ProjetoService projetoService;

    @InjectMocks
    private ProjetoController projetoController;

    @Test
    void testGetAllProjetos() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        when(projetoService.findAll()).thenReturn(Collections.singletonList(projeto));

        List<ProjetoResponse> result = projetoController.getAllProjetos();

        assertEquals(1, result.size());
        verify(projetoService, times(1)).findAll();
    }

    @Test
    void testCreateProjeto() {
        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Teste", "PENDENTE", 1L);
        ProjetoResponse projetoResponse = new ProjetoResponse(1L, "Projeto Teste", "PENDENTE", 1L);
        when(projetoService.save(projetoDTO)).thenReturn(projetoResponse);

        ResponseEntity<ProjetoResponse> result = projetoController.createProjeto(projetoDTO);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(projetoResponse, result.getBody());
        verify(projetoService, times(1)).save(projetoDTO);
    }

    @Test
    void testUpdateProjeto() {
        Long id = 1L;
        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Atualizado", "EM_PROGRESSO", 1L);
        ProjetoResponse projetoResponse = new ProjetoResponse( 1L, "Projeto Atualizado", "EM_PROGRESSO", 1L);
        when(projetoService.update(id, projetoDTO)).thenReturn(projetoResponse);

        ResponseEntity<ProjetoResponse> result = projetoController.updateProjeto(id, projetoDTO);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(projetoResponse, result.getBody());
        verify(projetoService, times(1)).update(id, projetoDTO);
    }

    @Test
    void testDeleteProjeto() {
        Long id = 1L;
        ResponseEntity<String> response = ResponseEntity.ok("Deletado com sucesso");
        when(projetoService.delete(id)).thenReturn(response);

        ResponseEntity<String> result = projetoController.deleteProjeto(id);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Deletado com sucesso", result.getBody());
        verify(projetoService, times(1)).delete(id);
    }
}