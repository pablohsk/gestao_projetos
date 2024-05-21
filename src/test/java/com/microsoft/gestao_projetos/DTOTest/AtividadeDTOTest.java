package com.microsoft.gestao_projetos.DTOTest;

import com.microsoft.gestao_projetos.DTO.AtividadeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtividadeDTOTest {

    @Test
    void testAtividadeDTO() {
        AtividadeDTO atividadeDTO = new AtividadeDTO(1L, "Descricao Teste", null, 1L);

        assertEquals("Descricao Teste", atividadeDTO.descricao());
        assertEquals(1L, atividadeDTO.projeto_id());
    }
}