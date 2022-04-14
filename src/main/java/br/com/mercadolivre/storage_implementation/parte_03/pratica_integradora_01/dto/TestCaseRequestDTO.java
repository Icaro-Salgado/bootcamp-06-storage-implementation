package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.dto;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.model.TestCase;

import java.util.Date;

public class TestCaseToBeCreatedDTO {

    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private Date last_update;

    public TestCase toModel() {
        return TestCase
                .builder()
                .description(this.description)
                .tested(this.tested)
                .passed(this.passed)
                .number_of_tries(this.number_of_tries)
                .last_update(this.last_update)
                .build();
    }
}
