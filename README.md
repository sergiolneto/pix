# Projeto de Gerenciamento e API PIX (Padrão BACEN)

Este projeto é uma aplicação backend desenvolvida em Java com Spring Boot, destinada ao gerenciamento de chaves PIX (DICT) e ao fornecimento de endpoints seguindo o padrão oficial `bacen/pix-api`.

## Objetivo

A aplicação atua como um **Provedor de API PIX**, permitindo:
1.  **Gerenciamento de Chaves**: Cadastro e validação de chaves CPF, CNPJ e Telefone.
2.  **Cobranças Imediatas (`/cob`)**: Criação e consulta de cobranças conforme o padrão BACEN.
3.  **Transações PIX (`/pix`)**: Consulta de transações recebidas.

## Tecnologias Utilizadas

*   **Java 21**
*   **Spring Boot 3.2.5**
*   **Spring Data JPA** (com banco H2 para persistência em memória)
*   **Lombok**
*   **JUnit 5 & MockMvc** (para testes automatizados)

## Estrutura do Projeto

O projeto está organizado no pacote base `br.com.pix`:

1.  **`br.com.pix.modelo`**:
    *   `ChavePix`: Entidade para chaves (CPF, CNPJ, etc).
    *   `Cobranca`: Entidade para cobranças imediatas.
    *   `PixTransaction`: Entidade para transações financeiras.

2.  **`br.com.pix.controller`**:
    *   `ChavePixCad`: Gerenciamento de chaves (`/chave`).
    *   `CobController`: Endpoints de cobrança (`/cob`).
    *   `PixController`: Endpoints de transação (`/pix`).

3.  **`br.com.pix.validadores`**:
    *   Validadores para CPF, CNPJ, Telefone, Agência e Conta.

## Como Executar

1.  Certifique-se de ter o Java 21 instalado.
2.  Execute o comando `./mvnw spring-boot:run`.
3.  Acesse o console do H2 em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:pixdb`).
