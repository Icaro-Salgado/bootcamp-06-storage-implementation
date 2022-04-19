package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.repository;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
}
