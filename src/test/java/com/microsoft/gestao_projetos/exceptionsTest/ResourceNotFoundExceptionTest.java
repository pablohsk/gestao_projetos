package com.microsoft.gestao_projetos.exceptionsTest;

import com.microsoft.gestao_projetos.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResourceNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        assertEquals("Resource not found", exception.getMessage());
    }

    @Test
    void testExceptionCause() {
        Throwable cause = new Throwable("Cause");
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found", cause);

        assertEquals("Resource not found", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testExceptionWithoutMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException();

        assertNotNull(exception);
    }
}
