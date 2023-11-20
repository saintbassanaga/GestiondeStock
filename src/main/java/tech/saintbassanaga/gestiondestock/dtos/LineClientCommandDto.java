package tech.saintbassanaga.gestiondestock.dtos;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.LineClientCommand;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.LineClientCommand}
 */
@Value
@Data
@Builder
public class LineClientCommandDto implements Serializable {
    UUID id;
    ArticleDto article;
    CommandClientDto commandClient;
    BigDecimal quantity;
    BigDecimal unitPrices;
    Integer enterpriseId;

    public LineClientCommandDto fromEntity(LineClientCommand lineClientCommand){

        if (lineClientCommand == null)
            return null;

        return LineClientCommandDto.builder()
                .id(lineClientCommand.getId())
                .article(article.fromEntity(lineClientCommand.getArticle()))
                .commandClient(commandClient.fromEntity(lineClientCommand.getCommandClient()))
                .quantity(lineClientCommand.getQuantity())
                .unitPrices(lineClientCommand.getUnitPrices())
                .build();
    }

    public LineClientCommand toEntity(LineClientCommandDto lineClientCommandDto){
        if (lineClientCommandDto == null)
            return null;

        LineClientCommand lineClientCommand = new LineClientCommand();

        lineClientCommand.setId(lineClientCommandDto.getId());
        lineClientCommand.setArticle(article.toEntity(lineClientCommandDto.getArticle()));
        lineClientCommand.setCommandClient(commandClient.toEntity(lineClientCommandDto.getCommandClient()));
        lineClientCommand.setQuantity(lineClientCommandDto.getQuantity());
        lineClientCommand.setQuantity(lineClientCommandDto.getUnitPrices());
        return lineClientCommand;
    }
}