# TECHCHALLENGE-GERENCIAMENTO-PRODUTOS
Projeto desenvolvido com o objetivo de criar um sistema de gerenciamento de entregas.

## Quais foram as tecnologias e ferramentas utilizadas:
  - Java 17
  - Spring
  - Docker
  - Mongo
  - Mockito
  - JUnit

## Desafios encontrados e soluções implementadas
No desenvolvimento de um microsserviço de gerenciamento de pedidos, enfrentamos desafios significativos em duas áreas principais: a adaptação à arquitetura de microsserviços e a implementação de tecnologias de nuvem usando Spring.
A primeira dificuldade foi dividir nosso sistema grande e monolítico em serviços menores e independentes. Isso exigiu muita análise para definir o que cada serviço deveria fazer, garantindo que eles fossem autônomos, mas ainda capazes de trabalhar juntos. A comunicação entre os microsserviços, feita via APIs RESTful.
Já a implementação de tecnologias de nuvem com o Spring, encontramos mais esforços na forma de utilização dos componentes disponibilizados e como implementar de maneira conjunta tais funcionalidades.

## Como utilizar o projeto:
  1 - Efetue o clone do projeto para uma pasta de sua preferência

  2 - Abra o terminal de sua preferência e navegue até o projeto

  3 - Execute o comando "docker compose up"

  4 - Abra um navegador da sua preferência e acesse a url: http://localhost:8080/swagger-ui/index.html para conseguir acessar o swagger onde estão especificadas todas as apis e chamadas.
