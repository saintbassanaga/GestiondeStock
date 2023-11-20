package tech.saintbassanaga.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Article}
 */
@Value
@Data
@Builder
public class ArticleDto implements Serializable {
    UUID id;
    String codeArticle;
    String designation;
    BigDecimal unitPriceHt;
    BigDecimal tauxTva;
    BigDecimal unitPriceTTC;
    String photo;
    CategoryDto category;

    @JsonIgnore
    List<SaleLineDto> saleLines;
    @JsonIgnore
    List<LineClientCommandDto> lineClientCommands;
    @JsonIgnore
    List<LineProviderCommandDto> lineProviderCommands;
    @JsonIgnore
    List<MovementStockDto> movementStocks;

    public static ArticleDto fromEntity(Article article){

        if (article == null)
            return null;

        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .tauxTva(article.getTauxTva())
                .unitPriceHt(article.getUnitPriceHt())
                .unitPriceTTC(article.getUnitPriceTTC())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();

    }

    public static Article toEntity(ArticleDto articleDto){

        if (articleDto == null)
            return null;

        Article article = new Article();

        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setUnitPriceHt(articleDto.getUnitPriceHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setUnitPriceTTC(articleDto.getUnitPriceTTC());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));

        return article;
    }

}