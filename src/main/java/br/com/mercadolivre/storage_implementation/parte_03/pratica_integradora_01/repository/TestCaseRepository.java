package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.repository;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdate(Date last_update);
}
