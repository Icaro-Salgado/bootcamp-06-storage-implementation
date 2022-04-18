package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.response;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ActorDetailDTO {
    private Integer id;
    private String firstName, lastName;
    private Double rating;
    private Movie favoriteMovie;
    private List<Movie> moviesAt;
    private Date createdAt, updatedAt;

    public static ActorDetailDTO fromModel(Actor actorModel) {
        return ActorDetailDTO
                .builder()
                .id(actorModel.getId())
                .firstName(actorModel.getFirstName())
                .lastName(actorModel.getLastName())
                .rating(actorModel.getRating())
                .favoriteMovie(actorModel.getFavoriteMovie())
                .moviesAt(actorModel.getMovies())
                .createdAt(actorModel.getCreatedAt())
                .updatedAt(actorModel.getUpdatedAt())
                .build();
    }
}
