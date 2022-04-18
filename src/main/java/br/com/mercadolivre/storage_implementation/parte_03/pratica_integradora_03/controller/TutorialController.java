package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.controller;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.TutorialListDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.TutorialRequestDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.dto.TutorialResponseDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Tutorial;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutorials")
public class TutorialController {

    private final TutorialService tutorialService;

    @PostMapping("/new")
    public ResponseEntity<Object> create(@RequestBody TutorialRequestDTO tutorialRequestDTO, UriComponentsBuilder uriBuilder) {
        Tutorial createdTutorial = tutorialService.saveTutorial(tutorialRequestDTO.toModel());

        URI uri = uriBuilder.path("/api/tutorials/{id}").buildAndExpand(createdTutorial.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/")
    public ResponseEntity<TutorialListDTO> listTutorials() {
        List<Tutorial> tutorials = tutorialService.listTutorials();

        List<TutorialResponseDTO> dtoList = tutorials.stream().map(TutorialResponseDTO::fromModel).collect(Collectors.toList());

        return ResponseEntity.ok(new TutorialListDTO(dtoList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialResponseDTO> getTestCaseById(@PathVariable Long id) {
        Tutorial tutorial = tutorialService.findTutorialById(id);

        return ResponseEntity.ok(TutorialResponseDTO.fromModel(tutorial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateById(@PathVariable Long id, @RequestBody TutorialRequestDTO tutorialRequestDTO) {

        Tutorial updated = tutorialService.saveTutorial(tutorialRequestDTO.toModel(id));

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        tutorialService.removeTutorial(id);

        return ResponseEntity.noContent().build();
    }
}
