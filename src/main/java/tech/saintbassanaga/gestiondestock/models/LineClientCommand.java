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
@Table(name = "lineClientCommand")
public class LineClientCommand extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commandClientId")
    private CommandClient commandClient;


    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrices;

    @Column(name = "enterpriseId")
    private Integer enterpriseId;
}
