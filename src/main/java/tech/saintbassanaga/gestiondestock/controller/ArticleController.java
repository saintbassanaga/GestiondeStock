package tech.saintbassanaga.gestiondestock.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.saintbassanaga.gestiondestock.controller.api.ArticleAPI;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;
import tech.saintbassanaga.gestiondestock.services.ArticleService;

import java.util.List;
import java.util.UUID;

import static tech.saintbassanaga.gestiondestock.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/articles")
public class ArticleController  implements ArticleAPI {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(UUID Id) {
        return articleService.findById(Id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(UUID Id) {
        articleService.delete(Id);
    }
}
