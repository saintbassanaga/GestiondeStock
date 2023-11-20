package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "movement_stock")
public class MovementStock extends AbstractEntity {
    @Column(name = "movement_date")
    private Instant MovementDate;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "article_Id")
    private Article article;

    @Column(name = "movement_type")
    @Enumerated(EnumType.STRING)
    private StockMovementType stockMovementType;

    @Column(name = "movement_source")
    @Enumerated(EnumType.STRING)
    private StockMovementSource movementSource;

    @Column(name = "enterprise_Id")
    private Integer enterpriseId;
}
