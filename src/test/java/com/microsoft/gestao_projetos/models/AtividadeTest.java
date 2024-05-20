package com.microsoft.gestao_projetos.models;

import com.microsoft.gestao_projetos.enumeration.StatusAtividade;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AtividadeTest {

    @Test
    void testAtividade() {
        Atividade atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Descricao Teste");
        atividade.setStatus(StatusAtividade.valueOf("PENDENTE"));
        atividade.setProjeto(new Projeto());

        assertEquals(1L, atividade.getId());
        assertEquals("Descricao Teste", atividade.getDescricao());
        assertEquals("PENDENTE", atividade.getStatus());
        assertNotNull(atividade.getProjeto());
    }

    @Test
    void testAtividadeNoArgsConstructor() {
        Atividade atividade = new Atividade();
        assertNull(atividade.getId());
        assertNull(atividade.getDescricao());
        assertNull(atividade.getStatus());
        assertNull(atividade.getProjeto());
    }
}
