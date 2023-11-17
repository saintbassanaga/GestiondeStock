package tech.saintbassanaga.gestiondestock.services.Impls;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;
import tech.saintbassanaga.gestiondestock.exceptions.EntityNotFoundException;
import tech.saintbassanaga.gestiondestock.exceptions.ErrorCode;
import tech.saintbassanaga.gestiondestock.exceptions.InvalidEntityException;
import tech.saintbassanaga.gestiondestock.models.Article;
import tech.saintbassanaga.gestiondestock.repository.ArticleRepository;
import tech.saintbassanaga.gestiondestock.services.ArticleService;
import tech.saintbassanaga.gestiondestock.validators.ArticleValidator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Getter
@Service("articleServiceImpl")
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public ArticleDto save(ArticleDto dto) {

        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Article is not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.
                        save(ArticleDto.toEntity(dto))
        );
    }

    @Override
    public ArticleDto findById(UUID Id) {
        if (Id == null) {
            log.error("Article ID is null");
            return null;
        }
        Article article = articleRepository.findById(Id).orElseThrow(
                () -> new EntityNotFoundException(
                        "There is no Article with Id =" + Id + "Founded in the Database",
                        ErrorCode.ARTICLE_NOT_FOUND));
        return ArticleDto.fromEntity(article);
    }


    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article code is null");
            return null;
        }

        Article article = articleRepository.findArticleByCodeArticle(codeArticle).orElseThrow(
                () -> new EntityNotFoundException("There is no article with code :" + codeArticle + "in the Database", ErrorCode.ARTICLE_NOT_FOUND));
        return ArticleDto.fromEntity(article);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository
                .findAll()
                .stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID Id) {
        if (Id == null) {
            log.error("Article not found");
            return;
        }
        articleRepository.deleteById(Id);
    }
}
