package br.com.mercadolivre.storage_implementation.parte_03.pratica_integradora_01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class TestCaseListDTO {
    List<TestCaseResponseDTO> testCaseResponseDTOList;
}
