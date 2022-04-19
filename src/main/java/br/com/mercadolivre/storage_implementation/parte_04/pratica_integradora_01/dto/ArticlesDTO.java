package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.dto;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Article;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class ArticlesDTO {

    private String title;
    private List<AuthorDTO> authorList;

    public Article dtoToModel(){
        List<Author> authors = authorList.stream().map(AuthorDTO::dtoToModel).collect(Collectors.toList());
        return new Article(
                title,
                authors
        );
    }
}
