package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.LineClientCommand;
import tech.saintbassanaga.gestiondestock.models.LineProviderCommand;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.LineProviderCommand}
 */
@Value
@Data
@Builder
public class LineProviderCommandDto implements Serializable {
    UUID id;
    BigDecimal quantity;
    BigDecimal unitPrices;
    Integer enterpriseId;
    ArticleDto article;
    CommandProviderDto commandProvider;
    public LineProviderCommandDto fromEntity(LineProviderCommand lineProviderCommand){
        if (lineProviderCommand == null)
            return null;

        return LineProviderCommandDto.builder()
                .id(lineProviderCommand.getId())
                .quantity(lineProviderCommand.getQuantity())
                .unitPrices(lineProviderCommand.getUnitPrices())
                .enterpriseId(lineProviderCommand.getEnterpriseId())
                .article(article.fromEntity(lineProviderCommand.getArticle()))
                .commandProvider(commandProvider.fromEntity(lineProviderCommand.getCommandProvider()))
                .build();
    }

    public LineProviderCommand toEntity(LineProviderCommandDto lineProviderCommandDto){
        if (lineProviderCommandDto == null)
            return null;

        LineProviderCommand lineProviderCommand = new LineProviderCommand();

        lineProviderCommand.setId(lineProviderCommandDto.getId());
        lineProviderCommand.setArticle(article.toEntity(lineProviderCommandDto.getArticle()));
        lineProviderCommand.setCommandProvider(commandProvider.toEntity(lineProviderCommandDto.getCommandProvider()));
        lineProviderCommand.setQuantity(lineProviderCommandDto.getQuantity());
        lineProviderCommand.setQuantity(lineProviderCommandDto.getUnitPrices());
        return lineProviderCommand;
    }
}