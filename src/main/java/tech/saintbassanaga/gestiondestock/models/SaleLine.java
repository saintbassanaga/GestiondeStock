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
@Table(name = "saleLine")
public class SaleLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sales sale;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "enterprise")
    private Integer enterpriseId;
}
