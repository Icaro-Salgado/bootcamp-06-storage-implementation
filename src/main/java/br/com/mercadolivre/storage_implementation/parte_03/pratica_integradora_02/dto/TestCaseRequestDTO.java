package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.dto;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_02.model.TestCase;

import java.util.Date;

public class TestCaseRequestDTO {

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
                .lastUpdate(this.last_update)
                .build();
    }

    public TestCase toModel(Long id) {
        return TestCase
                .builder()
                .id_case(id)
                .description(this.description)
                .tested(this.tested)
                .passed(this.passed)
                .number_of_tries(this.number_of_tries)
                .lastUpdate(this.last_update)
                .build();
    }
}
