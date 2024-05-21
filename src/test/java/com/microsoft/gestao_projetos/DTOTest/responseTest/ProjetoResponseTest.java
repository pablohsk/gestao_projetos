package com.microsoft.gestao_projetos.DTOTest.responseTest;

import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetoResponseTest {

    @Test
    void testProjetoResponse() {
        ProjetoResponse response = new ProjetoResponse(1L, "Projeto Teste","PENDENTE",1L,  Collections.emptyList());

        assertEquals(1L, response.cliente_id());
        assertEquals("Projeto Teste", response.nome());
        assertEquals("PENDENTE", response.status());
        assertEquals(2L, response.cliente_id());
        assertEquals("Cliente Teste", response.nome());
    }
}