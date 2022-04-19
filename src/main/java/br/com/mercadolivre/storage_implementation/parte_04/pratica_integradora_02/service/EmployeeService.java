package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.service;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Employee;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.hibernate.PropertyNotFoundException;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository productRepository;
    private final ElasticsearchRestTemplate template;

    public Employee saveEmployee(Employee product) {
        return productRepository.save(product);
    }

    public List<Employee> listEmployees() {
        List<Employee> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);

        return result;
    }

    public Employee find(String id) {
        Optional<Employee> optionalEmployee = productRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new PropertyNotFoundException("Employee " + id + " not found!");
        }

        return optionalEmployee.get();
    }

    public List<Employee> findAllBy(String param) {
        MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(param, "firstName", "lastName")
                .operator(Operator.OR)
                .type(MultiMatchQueryBuilder.Type.PHRASE);

        NativeSearchQuery result = new NativeSearchQueryBuilder().withQuery(query).build();

        SearchHits<Employee> employee = template.search(result, Employee.class, IndexCoordinates.of("products"));

        System.out.println(employee);

        return employee.stream().map(SearchHit::getContent).collect(Collectors.toList());

    }
}
