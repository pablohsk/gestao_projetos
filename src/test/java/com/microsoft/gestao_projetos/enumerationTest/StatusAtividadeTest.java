package com.microsoft.gestao_projetos.enumerationTest;

import org.junit.jupiter.api.Test;
import com.microsoft.gestao_projetos.enumeration.StatusAtividade;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatusAtividadeTest {

    @Test
    void testStatusValues() {
        StatusAtividade[] statuses = StatusAtividade.values();
        assertEquals(3, statuses.length);
        assertEquals(StatusAtividade.PENDENTE, statuses[0]);
        assertEquals(StatusAtividade.EM_PROGRESSO, statuses[1]);
        assertEquals(StatusAtividade.CONCLUIDA, statuses[2]);
    }

    @Test
    void testStatusValueOf() {
        assertEquals(StatusAtividade.PENDENTE, StatusAtividade.valueOf("PENDENTE"));
        assertEquals(StatusAtividade.EM_PROGRESSO, StatusAtividade.valueOf("EM_PROGRESSO"));
        assertEquals(StatusAtividade.CONCLUIDA, StatusAtividade.valueOf("CONCLUIDO"));
    }
}