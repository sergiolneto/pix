package br.com.pix.modelo;

import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cobranca {
    @Id
    private String txid;
    private String chave;
    private Double valor;
    private String status; // ATIVA, CONCLUIDA, etc.
    private Instant dataCriacao;
    private String solicitacaoPagador;
}
