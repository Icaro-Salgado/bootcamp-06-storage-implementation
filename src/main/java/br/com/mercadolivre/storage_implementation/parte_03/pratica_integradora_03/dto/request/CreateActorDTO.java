package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.request;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Movie;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateActorDTO {
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
    private List<Integer> moviesIds;

    public Actor toModel() {
        return Actor
                .builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .rating(this.rating)
                .build();
    }
}
