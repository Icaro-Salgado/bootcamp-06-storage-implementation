package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.repository;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<Long, TestCase> {
}
