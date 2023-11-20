package tech.saintbassanaga.gestiondestock.services;

import org.springframework.stereotype.Component;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;

import java.util.List;
import java.util.UUID;

@Component
public interface ArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto findById(UUID Id);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    void delete(UUID Id);
}
