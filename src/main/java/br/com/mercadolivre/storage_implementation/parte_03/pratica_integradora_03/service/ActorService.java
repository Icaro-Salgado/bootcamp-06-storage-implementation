package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.service;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.hibernate.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final MovieService movieService;

    public Actor updateActor(Integer id, Actor actor) {
        actor.setId(id);

        return actorRepository.save(actor);
    }

    public Integer createActor(Actor actor) {
        return saveActor(actor).getId();
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

