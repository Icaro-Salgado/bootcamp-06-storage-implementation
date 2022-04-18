package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.response;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ActorsListDTO {

    private String firstName, lastName;
    private Double rating;

    public static List<ActorsListDTO> fromModelList(List<Actor> modelList) {
        return modelList
                .stream()
                .map(a -> new ActorsListDTO(a.getFirstName(), a.getLastName(), a.getRating()))
                .collect(Collectors.toList());
    }
}
