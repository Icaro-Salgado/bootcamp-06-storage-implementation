package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.service;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.Tutorial;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService {
    private final TutorialRepository tutorialRepository;

    public Tutorial saveTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> listTutorials() {
        return tutorialRepository.findAll();
    }

    public Tutorial findTutorialById(Long id) {
        return tutorialRepository.findById(id).orElse(new Tutorial());
    }

    public void removeTutorial(Long id) {
        Optional<Tutorial> response = tutorialRepository.findById(id);

        if (response.isEmpty())
            return;

        tutorialRepository.deleteById(response.get().getId());
    }
}
