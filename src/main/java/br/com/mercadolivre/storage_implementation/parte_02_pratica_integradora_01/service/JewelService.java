package br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.service;

import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.exception.JewelNotFoundException;
import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.model.Jewel;
import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.repository.JewelRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JewelService {
  private final JewelRepository jewelRepository;

  public List<Jewel> listJewels() {
    return jewelRepository.findAll();
  }

  public Jewel findJewelById(Long id) throws JewelNotFoundException {
    return jewelRepository.findById(id).orElseThrow(JewelNotFoundException::new);
  }

  public Long addJewel(Jewel jewel) {
    Jewel savedJewel = jewelRepository.save(jewel);

    return savedJewel.getId();
  }

  public void deleteJewel(Long id) {
    Optional<Jewel> response = jewelRepository.findById(id);

    if (response.isEmpty()) {
      return;
    }

    Jewel jewelToDelete = response.get();
    jewelRepository.delete(jewelToDelete);
  }
}
