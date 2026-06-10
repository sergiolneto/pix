package br.com.pix;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import br.com.pix.modelo.ChavePix;
import org.junit.jupiter.api.BeforeEach;

class ChavePixApplicationTests {

    private ChavePix pix;

    @BeforeEach
    void setUp() {
        pix = new ChavePix();
    }

    void automacaoShouldInitializeFieldsCorrectly() {
        pix.automacao();

        assertNotNull(pix.getId());
        assertNotNull(pix.getDataCadastro());
        assertTrue(pix.isAtivo());
    }

    void atualizaShouldUpdateFieldsCorrectly() {
        pix.automacao();
        Instant initialDataCadastro = pix.getDataCadastro();

        pix.atualiza();

        assertTrue(pix.isAtivo());
        assertNotNull(pix.getDataAteracao());
        assertNotEquals(initialDataCadastro, pix.getDataAteracao());
    }

    void setEnabledShouldThrowUnsupportedOperationException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> pix.setEnabled(true));

        assertEquals("Unimplemented method 'setEnabled'", exception.getMessage());
    }
}