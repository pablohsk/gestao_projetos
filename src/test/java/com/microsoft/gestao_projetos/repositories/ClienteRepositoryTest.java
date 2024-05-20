package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testSaveAndFindById() {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        clienteRepository.save(cliente);

        Optional<Cliente> foundCliente = clienteRepository.findById(cliente.getId());
        assertTrue(foundCliente.isPresent());
        assertEquals("Cliente Teste", foundCliente.get().getNome());
    }
}
