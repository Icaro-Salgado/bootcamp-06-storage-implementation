package br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.controller;

import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.model.Jewel;
import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.service.JewelService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/joias")
@RequiredArgsConstructor
public class JewelController {

  private final JewelService jewelService;

  @GetMapping
  public ResponseEntity<List<Jewel>> listJewels() {
    return ResponseEntity.ok(jewelService.listJewels());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Jewel> finJewel(@PathVariable Long id) {
    return ResponseEntity.ok(jewelService.findJewelById(id));
  }

  @PostMapping
  public ResponseEntity<String> addJewel(
      @RequestBody Jewel jewelToInsert, UriComponentsBuilder uriComponentsBuilder) {

    Long insertedJewelId = jewelService.addJewel(jewelToInsert);

    URI uri = uriComponentsBuilder.path("/joias/{id}").buildAndExpand(insertedJewelId).toUri();

    return ResponseEntity.created(uri).body(insertedJewelId.toString());
  }

  @DeleteMapping
  public ResponseEntity<Object> remove(@RequestParam Long idToDelete) {
    jewelService.deleteJewel(idToDelete);

    return ResponseEntity.noContent().build();
  }

  @PutMapping
  public ResponseEntity<Object> update(
      @RequestBody Jewel jewelToUpdate,
      @RequestParam Long jewelIdToUpdate,
      UriComponentsBuilder uriComponentsBuilder) {

    jewelToUpdate.setId(jewelIdToUpdate);

    Long updatedId = jewelService.addJewel(jewelToUpdate);

    URI uri = uriComponentsBuilder.path("/joias/{id}").buildAndExpand(updatedId).toUri();

    return ResponseEntity.created(uri).build();
  }
}
