package br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.service;

import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.domain.Article;
import br.com.mercadolivre.storage_implementation.parte_04.pratica_integradora_01.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article createArticle(Article article){
        return articleRepository.save(article);
    }
}
