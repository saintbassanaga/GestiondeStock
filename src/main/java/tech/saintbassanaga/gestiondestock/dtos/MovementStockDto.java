package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;
import tech.saintbassanaga.gestiondestock.models.MovementStock;
import tech.saintbassanaga.gestiondestock.models.StockMovementSource;
import tech.saintbassanaga.gestiondestock.models.StockMovementType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link MovementStock}
 */
@Value
@Data
@Builder
public class MovementStockDto implements Serializable {
    UUID id;
    Instant MovementDate;
    BigDecimal quantity;
    ArticleDto article;
    StockMovementType stockMovementType;
    StockMovementSource movementSource;
    Integer enterpriseId;

    public MovementStockDto fromEntity(MovementStock movementStock){
        if (movementStock == null)
            return null;

        return MovementStockDto.builder()
                .id(movementStock.getId())
                .MovementDate(movementStock.getMovementDate())
                .article(article.fromEntity(movementStock.getArticle()))
                .stockMovementType(movementStock.getStockMovementType())
                .movementSource(movementStock.getMovementSource())
                .enterpriseId(movementStock.getEnterpriseId())
                .build();
    }

    public MovementStock toEntity(MovementStockDto movementStockDto){
        if (movementStockDto == null)
            return null;

        MovementStock movementStock = new MovementStock();

        movementStock.setId(movementStockDto.getId());
        movementStock.setMovementDate(movementStockDto.getMovementDate());
        movementStock.setArticle(article.toEntity(movementStockDto.getArticle()));
        movementStock.setStockMovementType(movementStockDto.getStockMovementType());
        movementStock.setMovementSource(movementStockDto.getMovementSource());
        movementStock.setEnterpriseId(movementStockDto.getEnterpriseId());

        return movementStock;
    }
}