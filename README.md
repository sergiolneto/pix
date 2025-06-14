# Projeto de Gerenciamento de Chaves PIX

Este projeto é uma aplicação backend desenvolvida em Java com o framework Spring Boot, destinada ao gerenciamento de chaves PIX.

## Objetivo

O principal objetivo da aplicação é permitir o cadastro e a validação de diferentes tipos de chaves PIX, como CPF, CNPJ e Telefone, interagindo com um banco de dados para persistir essas informações.

## Tecnologias Utilizadas

*   **Java**: Linguagem de programação principal.
*   **Spring Boot**: Framework para facilitar a criação de aplicações Java standalone e baseadas em Spring.
    *   **Spring Data JPA**: Para facilitar a interação com o banco de dados e o mapeamento objeto-relacional.
*   **Lombok**: Biblioteca para reduzir código boilerplate (ex: getters, setters, construtores).
*   **JPA (Java Persistence API)**: Especificação para persistência de dados.
*   **Maven/Gradle** (implícito pelo uso de Spring Boot): Gerenciador de dependências e build.

## Estrutura do Projeto e Componentes Principais

O projeto está organizado em pacotes que separam responsabilidades:

1.  **`br.com.bank.pix`**:
    *   `PixApplication.java`: Classe principal que inicializa a aplicação Spring Boot.

2.  **`br.com.bank.pix.modelo`**:
    *   `Pix.java`:
        *   É uma entidade JPA (`@Entity`) que representa uma chave PIX no sistema.
        *   Contém atributos como `id` (UUID), `tipoChave` (ex: CPF, CNPJ, TELEFONE), `valorChave`, `tipoConta`, `agencia`, `conta`, `nome`, `sobrenome`, `dataCadastro`, `dataAteracao` e `ativo`.
        *   Utiliza Lombok (`@Getter`, `@AllArgsConstructor`, `@NoArgsConstructor`) para gerar automaticamente métodos comuns.
        *   Possui métodos anotados com `@PrePersist` (`automacao`) e `@PreUpdate` (`atualiza`) para definir automaticamente o `id`, `dataCadastro`, `dataAteracao` e o status `ativo` durante as operações de persistência e atualização.
        *   O método `setEnabled` parece estar incompleto ou é um placeholder, pois lança `UnsupportedOperationException`.

3.  **`br.com.bank.pix.repositorio`**:
    *   `Cadpix.java`:
        *   Interface que estende `JpaRepository<Pix, UUID>`.
        *   Fornece métodos CRUD (Create, Read, Update, Delete) prontos para a entidade `Pix` sem a necessidade de implementação manual, além de outras funcionalidades de consulta.

4.  **`br.com.bank.pix.validadores`**:
    *   `ValidaChave.java`:
        *   Classe responsável por validar o `valorChave` de um objeto `Pix` com base no seu `tipoChave`.
        *   O método `valchave(Pix pix)` utiliza um `switch` para direcionar a validação:
            *   Se `tipoChave` for "CPF", utiliza `ValidadorCPF.isCPF()`.
            *   Se `tipoChave` for "CNPJ", utiliza `ValidadorCnpj.validaCnpj()`.
            *   Se `tipoChave` for "TELEFONE", utiliza `ValidadorTelefone.valida()`.
            *   Retorna `HttpStatus.BAD_REQUEST` se a validação falhar ou o tipo de chave for desconhecido, e `HttpStatus.CREATED` se a validação for bem-sucedida (embora `CREATED` seja mais comum para indicar sucesso na criação de um recurso, aqui parece indicar apenas que a chave é válida).
    *   `ValidadorTelefone.java`:
        *   Classe utilitária para validar números de telefone.
        *   O método estático `valida(String telefone)` usa uma expressão regular (`PADRAO_TELEFONE`) para verificar se o formato do telefone é válido. O padrão espera um formato internacionalizado (ex: `+55 (11) 98765-4321`).

## Funcionalidades Principais (Inferidas)

*   **Cadastro de Chaves PIX**: A entidade `Pix` e o repositório `Cadpix` sugerem a capacidade de salvar novas chaves PIX no banco de dados.
*   **Validação de Chaves PIX**: A classe `ValidaChave` implementa a lógica para verificar se os valores das chaves estão em formatos corretos para CPF, CNPJ e telefone.
*   **Atualização de Chaves PIX**: A anotação `@PreUpdate` na entidade `Pix` indica que há lógica para quando uma chave é atualizada.
*   **Gerenciamento Automático de Campos**: Datas de cadastro/alteração e ID são gerenciados automaticamente pela entidade `Pix`.

## Como Executar (Suposição Genérica)

1.  Certifique-se de ter o Java (JDK) e o Maven ou Gradle instalados.
2.  Configure as propriedades do banco de dados no arquivo `application.properties` ou `application.yml` (não fornecido, mas usual em projetos Spring Boot).
3.  Execute a classe `PixApplication.java` como uma aplicação Java.

Este é um resumo básico do projeto com base nos arquivos fornecidos. Para uma compreensão mais profunda, seria necessário analisar os controladores (endpoints da API), serviços e as classes de validação de CPF e CNPJ, que não foram incluídas.