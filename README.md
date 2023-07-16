<div align="center">
	
![GitHub top language"](https://img.shields.io/github/languages/top/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![Repository size"](https://img.shields.io/github/repo-size/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![GitHub last commit"](https://img.shields.io/github/last-commit/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![Repository issues"](https://img.shields.io/github/issues/rockofox/firefox-minima.svg?style=for-the-badge)
# Processo Seletivo SUPERA
**API RESTful em Java de dados de transferência de banco<br>[Repo. do Frontend em React](https://github.com/renatonunes74/PS_SUPERA_Frontend)**

[Como usar](#como-usar) -
[Funcionalidades](#funcionalidades) -
[Dependências necessárias](#dependências-necessárias) -
[Tecnologias usadas](#tecnologias-usadas)
<br>
</div>

## Pré-visualização
![](preview.gif)

## Como usar
1. Clone o repositório
    - `git clone https://github.com/renatonunes74/PS_SUPERA_Backend`
1. Entre na pasta
    - `cd PS_SUPERA_Backend/`
1. Rode localmente
    - CLI / via Terminal:
        - `mvn spring-boot:run`
    - Via IDE (JetBrains, Eclipse...)
1. Agora é só fazer as requisições para a API

### Funcionalidades
- [x] Listar todas as transferências
    - `http http://localhost:8080/transferencias`
- [x] Listar todas as transferências por **conta**
    - `http http://localhost:8080/transferencias/conta/{contaId}`
        - exemplo: `http http://localhost:8080/transferencias/conta/1`
- [x] Listar todas as transferências por **nome do operador de transação**
    - `http http://localhost:8080/transferencias/operador/{nomeOperadorTransacao}`
        - exemplo: `http http://localhost:8080/transferencias/operador/beltrano`
- [x] Listar todas as transferências por **período de tempo**
    - `http "localhost:8080/transferencias/filtro?inicio={dataInicial}&fim={dataFinal}"`
        - exemplo: `http "localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01"`
- [x] Listar todas as transferências por **período de tempo** e **conta**
    - `http "localhost:8080/transferencias/filtro?inicio={dataInicial}&fim={dataFinal}&conta={contaId}"`
        - exemplo: `http "localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01&conta=1"`
- [x] Listar todas as transferências por **período de tempo**, **conta** e **nome do operador de transação**
    - `http "localhost:8080/transferencias/filtro?inicio={dataInicial}&fim={dataFinal}&conta={contaId}&operador={nomeOperadorTransacao}"`
        - exemplo: `http "localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01&conta=1&operador=beltrano"`

### Dependências necessárias
- [Java 17 ou superior](https://dev.java/)

### Tecnologias usadas
- Linguagem: [Java](https://dev.java/)
    - Arquitetura: [Claen Architeture]()
    - Frameworks: [Spring Boot](https://spring.io/projects/spring-boot)
    - Testes unitários: [jUhit 5](https://junit.org/junit5/)
    - Bibliotecas:
        - [Lombok](https://projectlombok.org/) (Anotações para gerar automaticamente métodos getters, setters, construtores, entre outros, em tempo de compilação)
- Banco de dados: [H2](https://www.mysql.com/)
- Complementares:
     - [VHS](https://github.com/charmbracelet/vhs) (Criação de GIF do terminal via código)
     - [httpie](https://httpie.io/) (Maior facilidade para requisições HTTP (alternativa ao `curl` e `insomnia`))
