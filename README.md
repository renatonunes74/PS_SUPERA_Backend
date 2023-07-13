<div align="center">
	
![GitHub top language"](https://img.shields.io/github/languages/top/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![Repository size"](https://img.shields.io/github/repo-size/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![GitHub last commit"](https://img.shields.io/github/last-commit/renatonunes74/PS_SUPERA_Backend.svg?style=for-the-badge)
![Repository issues"](https://img.shields.io/github/issues/rockofox/firefox-minima.svg?style=for-the-badge)
![GitHub](https://img.shields.io/github/license/renatonunes74/PS_SUPERA_Backend?style=for-the-badge)
# Processo Seletivo SUPERA
**API RESTful em Java de dados de transferência de banco**

[Como usar](#como-usar) -
[Funcionalidades](#funcionalidades) -
[Dependências necessárias](#dependências-necessárias) -
[Tecnologias usadas](#tecnologias-usadas)
<!-- [Diagramas](#diagramas) -->
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
- Listar todas as transferências
    - `http http://localhost:8080/transferencia`
- Listar todas as transferências por nome
    - `http http://localhost:8080/transferencia/nome/{nome}`
- Listar todas as transferências por data
    - `http http://localhost:8080/transferencia/data/{data}`
- Listar todas as transferências por data e nome
    - `http http://localhost:8080/transferencia/data/{data}/nome/{nome}`

<!-- **OBS**: `price_in_cents` é preço em centavos (maior facilidade) -->

### Dependências necessárias
- [Java](https://dev.java/)

### Tecnologias usadas
- Linguagem: [Java](https://dev.java/)
    - Arquitetura: [Claen Architeture]()
    - Frameworks: [Spring Boot](https://spring.io/projects/spring-boot)
    - Bibliotecas:
        - [Lombok](https://projectlombok.org/) (Anotações para gerar automaticamente métodos getters, setters, construtores, entre outros, em tempo de compilação)
- Banco de dados: [H2](https://www.mysql.com/)
- Complementares:
     - [Mermerd](https://github.com/KarnerTh/mermerd) (Criação automática de diagrama de relacionamento)
     - [VHS](https://github.com/charmbracelet/vhs) (Criação de GIF do terminal via código)
     - [httpie](https://httpie.io/) (Maior facilidade para requisições HTTP (alternativa ao `curl` e `insomnia`))

<!-- ## Diagramas -->
<!-- ### Diagrama de classes -->
<!-- ```mermaid -->
<!-- classDiagram -->
<!-- class DemoApplicationTests { -->
<!--   void : contextLoads(); -->
<!-- } -->
<!-- class ProductController { -->
<!--   +getAllProducts(); -->
<!--   +deleteProduct(String); -->
<!--   +registerProduct(RequestProduct); -->
<!--   +updateProduct(RequestProduct); -->
<!-- } -->
<!-- class DemoApplication { -->
<!--   +static void main(String[]); -->
<!-- } -->
<!-- class Product { -->
<!--   -String : id; -->
<!--   -String : name; -->
<!--   -Integer price_in_cents; -->
<!--   -Boolean : active; -->
<!--   +String : getId(); -->
<!--   +String : getName(); -->
<!--   +Integer : getPrice_in_cents(); -->
<!--   +Boolean : getActive(); -->
<!--   +void : setId(String); -->
<!--   +void : setName(String); -->
<!--   +void : setPrice_in_cents(Integer); -->
<!--   +void : setActive(Boolean); -->
<!--   +boolean : equals(Object); -->
<!-- #boolean : canEqual(Object); -->
<!--   +int : hashCode(); -->
<!-- } -->
<!-- class RequestProduct { -->
<!--     -String : id; -->
<!--     -String : name; -->
<!--     -Integer price_in_cents; -->
<!--     +String : toString(); -->
<!--     +int hashCode(); -->
<!--     +boolean equals(Object); -->
<!--     +String : id(); -->
<!--     +String : name(); -->
<!--     +Integer price_in_cents(); -->
<!-- } -->
<!-- class ProductRepository { -->
<!--     <<interface>> -->
<!-- } -->
<!-- ProductRepository ..|> Product : Realization -->
<!-- RequestProduct ..|> Record : Realization -->
<!-- ``` -->
<!---->
<!-- ### Diagrama de relacionamento -->
<!-- ```mermaid -->
<!-- erDiagram -->
<!-- product { -->
<!--     varchar id -->
<!--         text name  -->
<!--         int price_in_cents  -->
<!--         tinyint active  -->
<!-- } -->
<!-- ``` -->
