package com.microsoft.gestao_projetos.service;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import com.microsoft.gestao_projetos.enumeration.StatusAtividade;
import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.models.Projeto;
import com.microsoft.gestao_projetos.repositories.AtividadeRepository;
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

public class AtividadeServiceTest {

    @InjectMocks
    private AtividadeService atividadeService;

    @Mock
    private AtividadeRepository atividadeRepository;

    @Mock
    private ProjetoRepository projetoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Atividade atividade = new Atividade();
        when(atividadeRepository.findAll()).thenReturn(Collections.singletonList(atividade));

        List<Atividade> atividades = atividadeService.findAll();
        assertEquals(1, atividades.size());
    }

    @Test
    void testSave() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);

        AtividadeDTO atividadeDTO = new AtividadeDTO(1L,"Descricao Teste", StatusAtividade.PENDENTE, 1L);
        Atividade atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Descricao Teste");
        atividade.setStatus(StatusAtividade.PENDENTE);
        atividade.setProjeto(projeto);

        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(projeto));
        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividade);

        AtividadeResponse response = atividadeService.save(atividadeDTO);
        assertEquals(1L, response.id());
        assertEquals("Descricao Teste", response.descricao());
    }

    @Test
    void testSaveThrowsException() {
        AtividadeDTO atividadeDTO = new AtividadeDTO(1L,"", StatusAtividade.PENDENTE, null);
        assertThrows(IllegalArgumentException.class, () -> atividadeService.save(atividadeDTO));
    }

    @Test
    void testUpdate() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);

        AtividadeDTO atividadeDTO = new AtividadeDTO(1L,"Descricao Teste", StatusAtividade.PENDENTE, 1L);
        Atividade atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Descricao Teste");
        atividade.setStatus(StatusAtividade.PENDENTE);
        atividade.setProjeto(projeto);

        when(atividadeRepository.findById(anyLong())).thenReturn(Optional.of(atividade));
        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(projeto));
        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividade);

        AtividadeResponse response = atividadeService.update(1L, atividadeDTO);
        assertEquals(1L, response.id());
        assertEquals("Descricao Teste", response.descricao());
    }

    @Test
    void testUpdateThrowsException() {
        AtividadeDTO atividadeDTO = new AtividadeDTO(1L,"", StatusAtividade.PENDENTE, null);
        assertThrows(IllegalArgumentException.class, () -> atividadeService.update(1L, atividadeDTO));
    }

    @Test
    void testDelete() {
        when(atividadeRepository.existsById(anyLong())).thenReturn(true);

        ResponseEntity<String> response = atividadeService.delete(1L);
        assertEquals("Deletado com sucesso", response.getBody());
    }

    @Test
    void testDeleteThrowsException() {
        when(atividadeRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> atividadeService.delete(1L));
    }
}
