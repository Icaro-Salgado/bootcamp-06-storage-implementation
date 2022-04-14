package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.service;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.TestCase;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestCaseService {
    private final TestCaseRepository testCaseRepository;

    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> listTestCases() {
        return testCaseRepository.findAll();
    }

    public List<TestCase> listTestCasesByLastUpdate(Date desiredLastUpdate) {
        return testCaseRepository.findAllByLastUpdate(desiredLastUpdate);
    }

    public TestCase findTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElse(new TestCase());
    }

    public void removeTestCase(Long id) {
        Optional<TestCase> response = testCaseRepository.findById(id);

        if (response.isEmpty())
            return;

        testCaseRepository.deleteById(response.get().getId_case());
    }
}
