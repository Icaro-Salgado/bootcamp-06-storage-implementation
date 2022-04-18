package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Tutorial;

public class TutorialRequestDTO {

    private String title;
    private String description;
    private boolean published;

    public Tutorial toModel() {
        return Tutorial
                .builder()
                .title(this.title)
                .description(this.description)
                .published(this.published)
                .build();
    }

    public Tutorial toModel(Long id) {
        return Tutorial
                .builder()
                .id(id)
                .title(this.title)
                .description(this.description)
                .published(this.published)
                .build();
    }
}
