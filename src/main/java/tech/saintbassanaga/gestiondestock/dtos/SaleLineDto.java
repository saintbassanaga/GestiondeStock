package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.SaleLine;
import tech.saintbassanaga.gestiondestock.models.Sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.SaleLine}
 */
@Value
@Data
@Builder
public class SaleLineDto implements Serializable {
    UUID id;
    SalesDto sale;
    BigDecimal quantity;
    ArticleDto article;
    BigDecimal unitPrice;
    Integer enterpriseId;

    public SaleLineDto fromEntity(SaleLine saleLine){
        if (saleLine == null)
            return null;

        return SaleLineDto.builder()
                .id(saleLine.getId())
                .sale(sale.fromEntity(saleLine.getSale()))
                .quantity(saleLine.getQuantity())
                .article(article.fromEntity(saleLine.getArticle()))
                .unitPrice(saleLine.getUnitPrice())
                .enterpriseId(sale.getEnterpriseId())
                .build();
    }

    public SaleLine toEntity(SaleLineDto saleLineDto){
        if (saleLineDto == null)
            return null;

        SaleLine saleLine = new SaleLine();

        saleLine.setId(saleLineDto.getId());
        saleLine.setSale(sale.toEntity(saleLineDto.getSale()));
        saleLine.setQuantity(saleLineDto.getQuantity());
        saleLine.setArticle(article.toEntity(saleLineDto.getArticle()));
        saleLine.setUnitPrice(saleLineDto.getUnitPrice());
        saleLine.setEnterpriseId(saleLineDto.getEnterpriseId());

        return saleLine;
    }
}