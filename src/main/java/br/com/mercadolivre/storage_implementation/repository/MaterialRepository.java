package br.com.mercadolivre.storage_implementation.repository;

import br.com.mercadolivre.storage_implementation.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
