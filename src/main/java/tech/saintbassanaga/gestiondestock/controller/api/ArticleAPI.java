package tech.saintbassanaga.gestiondestock.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;

import java.awt.*;
import java.util.List;
import java.util.UUID;
import static tech.saintbassanaga.gestiondestock.utils.Constants.APP_ROOT;

public interface articleController {

    @PostMapping(value =APP_ROOT+ "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(ArticleDto dto);

    @GetMapping(value = APP_ROOT+"/article/{articleID}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleID") UUID Id);

    @GetMapping(value = APP_ROOT+"/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT+"/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(APP_ROOT+"/article/delete/{Id}")
    void delete(UUID Id);
}
