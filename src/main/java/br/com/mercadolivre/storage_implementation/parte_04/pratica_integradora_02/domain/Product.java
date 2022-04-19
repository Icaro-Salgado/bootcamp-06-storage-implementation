package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;


@Document(indexName = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private Long storage;

    public Product(String name, String category, BigDecimal price, Integer quantity, Long storage) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.storage = storage;
    }
}
