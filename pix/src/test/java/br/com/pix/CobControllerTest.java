package br.com.pix;

import br.com.pix.modelo.Cobranca;
import br.com.pix.repositorio.CobrancaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveCriarCobranca() throws Exception {
        Cobranca cob = new Cobranca();
        cob.setChave("test@pix.com");
        cob.setValor(100.0);
        cob.setSolicitacaoPagador("Pagamento de teste");

        mockMvc.perform(put("/cob/abc123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cob)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.txid").value("abc123"))
                .andExpect(jsonPath("$.status").value("ATIVA"));
    }
}
