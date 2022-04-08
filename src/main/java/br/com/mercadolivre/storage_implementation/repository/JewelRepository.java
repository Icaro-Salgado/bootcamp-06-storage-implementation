package br.com.mercadolivre.storage_implementation.repository;

import br.com.mercadolivre.storage_implementation.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
