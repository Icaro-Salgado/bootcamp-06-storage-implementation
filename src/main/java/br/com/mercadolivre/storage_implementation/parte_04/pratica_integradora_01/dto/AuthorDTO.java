package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.dto;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private String name;

    public Author dtoToModel(){
        return new Author(name);
    }
}
