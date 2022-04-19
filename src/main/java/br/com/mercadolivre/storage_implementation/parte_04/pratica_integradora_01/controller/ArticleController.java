package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.controller;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Article;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.dto.ArticlesDTO;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/elasticsearch/articles")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Object> createArticle(@RequestBody ArticlesDTO article){
        Article articleCreated = articleService.createArticle(article.dtoToModel());

        return ResponseEntity.ok(articleCreated);
    }
}
