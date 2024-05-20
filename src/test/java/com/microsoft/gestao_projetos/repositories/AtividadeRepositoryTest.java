package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Atividade;
import com.microsoft.gestao_projetos.models.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AtividadeRepositoryTest {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Test
    void testFindByProjetoId() {
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste");
        projetoRepository.save(projeto);

        Atividade atividade = new Atividade();
        atividade.setDescricao("Descricao Teste");
        atividade.setProjeto(projeto);
        atividadeRepository.save(atividade);

        List<Atividade> atividades = atividadeRepository.findByProjetoId(projeto.getId());
        assertEquals(1, atividades.size());
        assertEquals("Descricao Teste", atividades.get(0).getDescricao());
    }
}
