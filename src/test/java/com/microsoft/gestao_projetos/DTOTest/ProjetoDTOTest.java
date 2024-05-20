package com.microsoft.gestao_projetos.DTOTest;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetoDTOTest {

    @Test
    void testProjetoDTO() {
        ProjetoDTO projetoDTO = new ProjetoDTO("Projeto Teste", "PENDENTE", 1L);

        assertEquals("Projeto Teste", projetoDTO.nome());
        assertEquals("PENDENTE", projetoDTO.status());
        assertEquals(1L, projetoDTO.id_client());
    }
}
