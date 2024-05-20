package com.microsoft.gestao_projetos.DTOTest.responseTest;

import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtividadeResponseTest {

    @Test
    void testAtividadeResponse() {
        AtividadeResponse response = new AtividadeResponse(1L, "Descricao Teste", "PENDENTE", 2L);

        assertEquals(1L, response.id());
        assertEquals("Descricao Teste", response.descricao());
        assertEquals("PENDENTE", response.status());
        assertEquals(2L, response.id_projeto());
    }
}
