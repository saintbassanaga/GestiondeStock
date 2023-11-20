package tech.saintbassanaga.gestiondestock.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;

import java.util.List;
import java.util.UUID;
public interface ArticleAPI {

    @PostMapping(value ="/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(ArticleDto dto);

    @GetMapping(value ="findBy/byID/{articleID}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleID") UUID Id);

    @GetMapping(value ="/find/byCode/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value ="/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping("/delete/byId/{Id}")
    void delete(@PathVariable("Id") UUID Id);
}
