package com.microsoft.gestao_projetos.controllers;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.service.AtividadeService;
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
public class AtividadeControllerTest {

    @Mock
    private AtividadeService atividadeService;

    @InjectMocks
    private AtividadeController atividadeController;

    @Test
    void testGetAllAtividades() {
        Atividade atividade = new Atividade();
        when(atividadeService.findAll()).thenReturn(Collections.singletonList(atividade));

        List<Atividade> result = atividadeController.getAllAtividades();

        assertEquals(1, result.size());
        verify(atividadeService, times(1)).findAll();
    }

    @Test
    void testCreateAtividade() {
        AtividadeDTO atividadeDTO = new AtividadeDTO("descricao", null, 1L);
        AtividadeResponse response = new AtividadeResponse(1L, "descricao", "PENDENTE", 1L);
        when(atividadeService.save(atividadeDTO)).thenReturn(response);

        ResponseEntity<AtividadeResponse> result = atividadeController.createAtividade(atividadeDTO);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(response, result.getBody());
        verify(atividadeService, times(1)).save(atividadeDTO);
    }

    @Test
    void testUpdateAtividade() {
        Long id = 1L;
        AtividadeDTO atividadeDTO = new AtividadeDTO("descricao", null, 1L);
        AtividadeResponse response = new AtividadeResponse(1L, "descricao", "PENDENTE", 1L);
        when(atividadeService.update(id, atividadeDTO)).thenReturn(response);

        ResponseEntity<AtividadeResponse> result = atividadeController.updateAtividade(id, atividadeDTO);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(response, result.getBody());
        verify(atividadeService, times(1)).update(id, atividadeDTO);
    }

    @Test
    void testDeleteAtividade() {
        Long id = 1L;
        ResponseEntity<String> response = ResponseEntity.ok("Deletado com sucesso");
        when(atividadeService.delete(id)).thenReturn(response);

        ResponseEntity<String> result = atividadeController.deleteAtividade(id);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Deletado com sucesso", result.getBody());
        verify(atividadeService, times(1)).delete(id);
    }
}
