package br.com.bank.pix.modelo;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pix {

@Id
private UUID id;
private String tipoChave;
private String valorChave;
private String tipoConta;
private String agencia;
private String conta;
private String nome;
private String sobrenome;
private Instant dataCadastro;
private Instant dataAteracao;
private boolean ativo;

@PrePersist
public void automacao(){
    id = UUID.randomUUID();
    dataCadastro = Instant.now();
    ativo = true;
}

@PreUpdate
public void atualiza(){
    ativo = true;
    dataAteracao = Instant.now();
}

public void setEnabled(Boolean valor) {
    throw new UnsupportedOperationException("Unimplemented method 'setEnabled'");
}


}
