package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.repository;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
