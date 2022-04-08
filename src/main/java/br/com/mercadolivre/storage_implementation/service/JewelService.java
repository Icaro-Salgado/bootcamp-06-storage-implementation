package br.com.mercadolivre.storage_implementation.service;

import br.com.mercadolivre.storage_implementation.exception.JewelNotFoundException;
import br.com.mercadolivre.storage_implementation.model.Jewel;
import br.com.mercadolivre.storage_implementation.repository.JewelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
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
