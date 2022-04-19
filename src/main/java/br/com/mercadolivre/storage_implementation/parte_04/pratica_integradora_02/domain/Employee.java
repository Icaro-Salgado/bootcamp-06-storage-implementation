package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    private String id;
    private String firstName, lastName, city, state;

    public Employee(String firstName, String lastName, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
    }
}
