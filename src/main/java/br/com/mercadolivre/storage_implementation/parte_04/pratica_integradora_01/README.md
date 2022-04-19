## Atividade N° 1

> Controlador REST para Elasticsearch

## Objetivo
O objetivo deste exercício é entender como usar o Spring Data Elasticsearch em um projeto
Spring e definir nosso primeiro controlador REST que faz uso do Elasticsearch.


## Classe Article
Conclua o passo a passo adicionando os serviços necessários e as camadas do
controlador para adicionar um documento do tipo artigo. Você precisará passar um JSON
com o seguinte formato:

![img.png](img.png)

E a resposta deve ser:

![img_1.png](img_1.png)

Observar que:
- O ID é aquele gerado pelo mecanismo Elasticsearch.
- Observe após carregar alguns artigos que se entrarem em http://localhost:9200/_cat/indices poderão observar o índice criado
![img_2.png](img_2.png)