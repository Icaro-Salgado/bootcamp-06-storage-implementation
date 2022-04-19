package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.repository;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_02.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
