package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "LineProviderCommand")
public class LineProviderCommand extends AbstractEntity {

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprices")
    private BigDecimal unitPrices;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commandProviderId")
    private CommandProvider commandProvider;
}
