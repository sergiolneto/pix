package br.com.pix;

import br.com.pix.modelo.ChavePix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ChavePixTest {

    @Test
    @DisplayName("Should create ChavePix object with no-args constructor")
    void shouldCreateWithNoArgsConstructor() {
        ChavePix pix = new ChavePix();
        assertNotNull(pix);
        assertNull(pix.getId()); // Fields are null/default before persistence
    }

    @Test
    @DisplayName("Should create ChavePix object with all-args constructor and getters should work")
    void shouldCreateWithAllArgsConstructorAndTestGetters() {
        // Arrange
        UUID id = UUID.randomUUID();
        Instant now = Instant.now();

        // Act
        ChavePix pix = new ChavePix(
                id,
                "EMAIL",
                "test@example.com",
                "CORRENTE",
                "0001",
                "12345-6",
                "John",
                "Doe",
                now,
                now,
                true
        );

        // Assert
        assertAll("Verify all fields are set correctly by the constructor",
                () -> assertEquals(id, pix.getId()),
                () -> assertEquals("EMAIL", pix.getTipoChave()),
                () -> assertEquals("test@example.com", pix.getValorChave()),
                () -> assertEquals("CORRENTE", pix.getTipoConta()),
                () -> assertEquals("0001", pix.getAgencia()),
                () -> assertEquals("12345-6", pix.getConta()),
                () -> assertEquals("John", pix.getNome()),
                () -> assertEquals("Doe", pix.getSobrenome()),
                () -> assertEquals(now, pix.getDataCadastro()),
                () -> assertEquals(now, pix.getDataAteracao()),
                () -> assertTrue(pix.isAtivo())
        );
    }

    @Test
    @DisplayName("PrePersist callback should set id, dataCadastro, and ativo status")
    void prePersistShouldSetDefaultValues() {
        // Arrange
        ChavePix pix = new ChavePix();

        // Pre-condition asserts
        assertNull(pix.getId());
        assertNull(pix.getDataCadastro());
        assertFalse(pix.isAtivo());

        // Act
        pix.automacao(); // Manually trigger the @PrePersist method for unit testing

        // Assert
        assertNotNull(pix.getId());
        assertNotNull(pix.getDataCadastro());
        assertTrue(pix.isAtivo());
    }

    @Test
    @DisplayName("PreUpdate callback should set dataAlteracao and ativo status")
    void preUpdateShouldSetUpdateValues() {
        // Arrange
        ChavePix pix = new ChavePix();
        assertNull(pix.getDataAteracao()); // Pre-condition

        // Act
        pix.atualiza(); // Manually trigger the @PreUpdate method for unit testing

        // Assert
        assertNotNull(pix.getDataAteracao());
        assertTrue(pix.isAtivo());
    }

    @Test
    @DisplayName("setEnabled should throw UnsupportedOperationException")
    void setEnabledShouldThrowException() {
        // Arrange
        ChavePix pix = new ChavePix();

        // Act & Assert
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> pix.setEnabled(false));

        assertEquals("Unimplemented method 'setEnabled'", exception.getMessage());
    }
}