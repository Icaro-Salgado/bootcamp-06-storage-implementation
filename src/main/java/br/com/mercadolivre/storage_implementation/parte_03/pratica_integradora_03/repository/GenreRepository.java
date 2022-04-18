package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.repository;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
