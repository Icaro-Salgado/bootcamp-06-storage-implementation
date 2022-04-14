package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.dto;

import br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.model.TestCase;
import lombok.Builder;

import java.util.Date;

@Builder
public class TestCaseResponseDTO {
    private Long id_case;
    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private Date last_update;

    public static TestCaseResponseDTO fromModel(TestCase testCaseToConvert) {
        return TestCaseResponseDTO
                .builder()
                .id_case(testCaseToConvert.getId_case())
                .description(testCaseToConvert.getDescription())
                .tested(testCaseToConvert.isTested())
                .passed(testCaseToConvert.isPassed())
                .number_of_tries(testCaseToConvert.getNumber_of_tries())
                .last_update(testCaseToConvert.getLastUpdate())
                .build();
    }
}
