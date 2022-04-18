package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.controller;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.request.CreateActorDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.response.ActorDetailDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.response.ActorsListDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping
    public ResponseEntity<Object> createActor(@RequestBody CreateActorDTO createActorDTO) {
        Actor actorToSave = actorService.createActorFromDTO(createActorDTO);

        Integer savedId = actorService.createActor(actorToSave);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ActorsListDTO>> listActors() {
        List<Actor> actors = actorService.listAll();

        return ResponseEntity.ok(ActorsListDTO.fromModelList(actors));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDetailDTO> findActor(@PathVariable Integer id) {
        Actor foundedActor = actorService.findActorById(id);

        return ResponseEntity.ok(ActorDetailDTO.fromModel(foundedActor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateActor(@RequestBody CreateActorDTO actorToUpdate, @PathVariable Integer id) {
        Integer actorUpdatedId = actorService.updateActor(id, actorToUpdate.toModel());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(actorUpdatedId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActor(@PathVariable Integer id) {
        actorService.removeActorById(id);

        return ResponseEntity.noContent().build();
    }
}
