package tech.saintbassanaga.gestiondestock.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "ligneVente")
public class LigneVente extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "venteId")
    private Ventes  ventes;

    private BigDecimal quantity;
}
