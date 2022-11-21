# API de Liquidação Financeira Multilateral

    O arquivo SLC0001-modelo.xml que se encontra na pasta src/main/resources do repositório informa movimentos bilaterais de liquidação multilateral realizados em determinado dia.
    
    O aplicativo tem a função de carregar esse arquivo para um banco de dados e disponibilizar as informações em uma API.
    
    
## Tecnologias

1. O projeto utiliza o Java 11;
2. Processo de build foi feito via Maven Dependency Management;
3. O framework utilizado foi o Spring Boot:

    + Spring Web - Para fazer a camada de exposição da API Rest;
    + Spring Data JPA - Para fazer a camada de interação com o banco de dados (DAO);
    + Spring Batch - Para fazer o processamento e o load do arquivo xml no banco de dados;

4. Hibernate ORM para mapeamento das entidades do banco de dados;
6. O banco de dados é o H2 que salva as informações em memória;
7. Foi utilizado as anotações do JAXB para fazer o de/para do arquivo xml para os objetos;
8. A API está rodando no host Heroku;

## Setup e execução da aplicação

Para acessar os dados do arquivo é possível utilizar o console do h2, url da API ou link para o host Heroku.

Para acessar as duas primeiras opções primeiramente faça a clonagem do repositório e inicie a aplicação.

O console h2 pode ser acessado através do link [http://localhost:8080/liq-fin-multilateral/h2/](http://localhost:8080/liq-fin-multilateral/h2/). Para logar nesse banco utilize a string de conexão "jdbc:h2:mem:bdh2", usuário "root" e senha "root".

## URL da API
[http://localhost:8080/liq-fin-multilateral/v1/operacoes](http://localhost:8080/liq-fin-multilateral/v1/operacoes).


## Link para o Heroku
[https://liq-fina-multilateral.herokuapp.com/liq-fin-multilateral/v1/operacoes](https://liq-fina-multilateral.herokuapp.com/liq-fin-multilateral/v1/operacoes)

