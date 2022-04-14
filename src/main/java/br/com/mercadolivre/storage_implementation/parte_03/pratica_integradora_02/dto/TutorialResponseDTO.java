package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.dto;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.Tutorial;
import lombok.Builder;

import java.util.Date;

@Builder
public class TutorialResponseDTO {
    private Long id;
    private String title;
    private String description;
    private boolean published;

    public static TutorialResponseDTO fromModel(Tutorial tutorialToConvert) {
        return TutorialResponseDTO
                .builder()
                .id(tutorialToConvert.getId())
                .title(tutorialToConvert.getTitle())
                .description(tutorialToConvert.getDescription())
                .published(tutorialToConvert.isPublished())
                .build();
    }
}
