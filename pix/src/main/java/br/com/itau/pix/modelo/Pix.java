package br.com.itau.pix.modelo;

import java.time.Instant;
import java.util.UUID;

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
private Instant dataIncl;

@PrePersist
public void automacao(){
    id = UUID.randomUUID();
    dataCadastro = Instant.now();
}

@PreUpdate
public void atualiza(){
    dataIncl = Instant.now();
}
}
