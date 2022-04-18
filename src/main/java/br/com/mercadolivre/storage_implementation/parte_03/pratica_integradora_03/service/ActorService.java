package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.service;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.request.CreateActorDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Movie;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.hibernate.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final MovieService movieService;

    public Integer updateActor(Integer id, Actor actor) {
        actor.setId(id);

        return this.saveActor(actor).getId();
    }

    public Integer createActor(Actor actor) {
        return saveActor(actor).getId();
    }

    // IDK if it is right to use a DTO on service layer, but was the only solution I found
    public Actor createActorFromDTO(CreateActorDTO actorDTO) {
        Actor actor = actorDTO.toModel();

        if (actorDTO.getMoviesIds() != null) {
            List<Movie> movies = actorDTO.getMoviesIds()
                    .stream()
                    .map(movieService::findMovieById)
                    .collect(Collectors.toList());
            actor.setMovies(movies);
        }

        return actor;
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> listAll() {
        return actorRepository.findAll();
    }

    public Actor findActorById(Integer id) {
        Optional<Actor> response = actorRepository.findById(id);

        if (response.isEmpty()) {
            throw new PropertyNotFoundException("Actor not found");
        }

        return response.get();
    }

    public Actor removeActorById(Integer id) {
        Actor actor = findActorById(id);

        actor.getMovies().forEach(m -> {
            m.getActors().remove(actor);
            movieService.saveMovie(m);
        });

        actorRepository.deleteById(id);

        return actor;
    }
}

