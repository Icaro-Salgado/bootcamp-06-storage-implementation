package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.controller;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Product;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.dto.ProductDTO;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/elasticsearch/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProductDTO newProduct) {
        Product created = productService.saveProduct(newProduct.toModel());

        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<?> listProducts(@RequestParam String name) {
        List<Product> found = productService.findAllBy(name);

        return ResponseEntity.ok(found);
    }
}
