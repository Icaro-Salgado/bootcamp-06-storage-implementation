package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.dto;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Employee;

public class EmployeeDTO {
    private String firstName, lastName, city, state;

    public Employee toModel() {
        return new Employee(
                this.firstName,
                this.lastName,
                this.city,
                this.state
        );
    }
}
