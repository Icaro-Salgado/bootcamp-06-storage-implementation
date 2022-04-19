package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.controller;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Employee;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.dto.EmployeeDTO;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elasticsearch/products")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService productService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody EmployeeDTO newEmployee) {
        Employee created = productService.saveEmployee(newEmployee.toModel());

        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<?> listEmployees(@RequestParam String name) {
        List<Employee> found = productService.findAllBy(name);

        return ResponseEntity.ok(found);
    }
}
