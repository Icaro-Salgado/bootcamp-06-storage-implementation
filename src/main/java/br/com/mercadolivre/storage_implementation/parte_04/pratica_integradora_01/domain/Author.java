package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {

    private String name;

    public Author(String name) {
        this.name = name;
    }
}
