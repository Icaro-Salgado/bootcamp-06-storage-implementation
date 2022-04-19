package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.dto;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private Long storage;

    public Product toModel() {
        return new Product(
                name,
                category,
                price,
                quantity,
                storage
        );
    }
}
