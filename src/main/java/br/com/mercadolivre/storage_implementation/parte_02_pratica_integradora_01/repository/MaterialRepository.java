package br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.repository;

import br.com.mercadolivre.storage_implementation.parte_02_pratica_integradora_01.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
