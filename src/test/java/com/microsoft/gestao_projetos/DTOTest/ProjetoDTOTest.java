package com.microsoft.gestao_projetos.DTOTest;

import com.microsoft.gestao_projetos.DTO.ProjetoDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetoDTOTest {

    @Test
    void testProjetoDTO() {
        ProjetoDTO projetoDTO = new ProjetoDTO(1L, "Projeto Teste", "PENDENTE", 1L,  Collections.emptyList());

        assertEquals("Projeto Teste", projetoDTO.nome());
        assertEquals("PENDENTE", projetoDTO.status());
        assertEquals(1L, projetoDTO.cliente_id());
    }
}
