package br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.service;

import br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.repository.MaterialRepository;
import br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.model.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService {

  private final MaterialRepository materialRepository;

  public Long addMaterial(Material material) {
    Material savedMaterial = materialRepository.save(material);

    return savedMaterial.getId();
  }
}
