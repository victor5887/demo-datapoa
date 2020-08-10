# Avaliação Técnica 
 
Para atender os critérios da avaliação técnica, foi desenvolvido o módulo de backend para manipulação e persistência das entidades do sistema.
Em função do prazo e de outros aspectos do escopo da avaliação, **não foi possível concluir todas as funcionalidades esperadas** junto a disponibilização da imagem do docker.
 

### Requisitos
  - Java Jdk 1.8
  - Maven >3
-----------------------
### Configurações e Propriedades
No arquivo **src\main\resources\application.properties**,  verificar o valor do parâmetros da propriedade **spring.datasource.url** que determina o diretório onde ficaram armazenados os arquivos da base de dados.
  ```
  #src\main\resources\application.properties
    
  spring.datasource.url=jdbc:h2:file:C:/data/demo/testdb
  ```
  
  ----------------------------
### Execução

Para execução do projeto será necessário primeiro configurar a jdk e o maven, em seguida efetuar o download dos fontes do projeto [aqui](https://github.com/victor5887/demo_cred_card.git "aqui").

  ```
$/ mvn spring-boot:run
  ```
  
 Para visualizar os dados da API de manipulação das entidades, no navegador acessar a url: http://localhost:8081/swagger-ui.html 
  
  [![application.properties](https://raw.githubusercontent.com/victor5887/demo_cred_card/master/src/main/resources/static/img/cap2.png "application.properties")](https://github.com/victor5887/demo_cred_cardhttps://github.com/victor5887/demo_cred_card "application.properties")
  
