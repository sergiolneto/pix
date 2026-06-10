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
public class PixTransaction {
    @Id
    private String endToEndId;
    private String txid;
    private Double valor;
    private String chave;
    private Instant horario;
    private String infoPagador;
}
