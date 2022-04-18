package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.repository;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_03.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
