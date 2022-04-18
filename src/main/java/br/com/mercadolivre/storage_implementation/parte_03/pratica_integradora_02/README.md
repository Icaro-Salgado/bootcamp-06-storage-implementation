## Tutoriais
> Prática integradora

### Objetivo
O principal objetivo desta prática é fortalecer o conhecimento visto e implementar uma API
REST que permita que os dados persistam em um banco de dados relacional.

## Exercício

Um aluno da academia depois de concluir com sucesso todos os cursos que iniciou, decide
criar alguns tutoriais para colocar em prática os conhecimentos aprendidos e revisá-los
caso se esqueça de algumas coisas.
É muito importante para ele que os dados sejam armazenados corretamente e estejam
disponíveis para quando quiser consultá-los novamente. Para fazer isso, você decide
implementar um serviço REST que permite alcançá-lo.

Uma entidade chamada “Tutorial” deve ser criada com os seguintes atributos:
- ID do movies.
- Título do movies.
- Descrição do movies.
- Situação da publicação.

A API deve ser capaz de:
1. Criar, recuperar, atualizar e excluir tutoriais.
2. Dê suporte a métodos de pesquisa personalizados, como pesquisar por status de
   publicação ou por título.

Endpoints que se deben desarrollar:
   
MÉTODO | URI | AÇÃO
------ | --- | ----
POST | /api/movies |Crie um novo Tutorial.
GET | /api/movies |Retorne todos os tutoriais.
GET | /api/movies/id |Retornar um movies por id.
PUT | /api/movies/id |Atualizar um movies por id.
DELETE | /api/movies |Excluir todos os tutoriais   
DELETE | /api/movies/id | Excluir um movies por id