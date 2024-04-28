package br.com.itau.pix.modelo;

import java.time.Instant;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pix {

@Id
private UUID id;
private String tipoChave;
private String valorChave;
private String tipoConta;
private Integer agencia;
private String conta;
private String nome;
private String sobrenome;
private Instant dataCadastro;
private Instant dataInclusao;

@PrePersist
public void automacao(){
    Logger logger = Logger.getLogger(this.getName());
    id = UUID.randomUUID();
    dataCadastro = Instant.now();
    if(tipoChave.equals("ALEATORIA")){

                    String randomString = RandomStringUtils.randomAlphanumeric(36);
                    logger.info(randomString);
    }
}

private String getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
}

@PreUpdate
public void atualiza(){
    dataInclusao = Instant.now();
}
}
