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
@Table(name = "line_Provider_Command")
public class LineProviderCommand extends AbstractEntity {

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprices")
    private BigDecimal unitPrices;

    @Column(name = "enterprise_Id")
    private Integer enterpriseId;

    @ManyToOne
    @JoinColumn(name = "article_Id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "command_Provider_Id")
    private CommandProvider commandProvider;
}
