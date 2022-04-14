package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.controller;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.dto.TestCaseListDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.dto.TestCaseRequestDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.service.TestCaseService;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.dto.TestCaseResponseDTO;
import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.TestCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<Object> create(@RequestBody TestCaseRequestDTO testCase, UriComponentsBuilder uriBuilder) {
        TestCase createdTestCase = testCaseService.saveTestCase(testCase.toModel());

        URI uri = uriBuilder.path("/api/testcases/{id}").buildAndExpand(createdTestCase.getId_case()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/")
    public ResponseEntity<TestCaseListDTO> listTestCases(UriComponentsBuilder uriBuilder) {
        List<TestCase> testCases = testCaseService.listTestCases();

        List<TestCaseResponseDTO> dtoList = testCases.stream().map(TestCaseResponseDTO::fromModel).collect(Collectors.toList());

        return ResponseEntity.ok(new TestCaseListDTO(dtoList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = testCaseService.findTestCaseById(id);

        return ResponseEntity.ok(TestCaseResponseDTO.fromModel(testCase));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateById(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseDTO) {

        TestCase updated = testCaseService.saveTestCase(testCaseDTO.toModel(id));

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        testCaseService.removeTestCase(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<TestCaseListDTO> getTestCasesByDate(
            @RequestParam Date last_update,
            UriComponentsBuilder uriBuilder) {

        List<TestCase> testCases = testCaseService.listTestCasesByLastUpdate(last_update);

        return ResponseEntity.ok(
                new TestCaseListDTO(testCases.stream().map(TestCaseResponseDTO::fromModel).collect(Collectors.toList())));
    }
}
