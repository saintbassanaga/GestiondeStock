package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity{

    private String code;

    @OneToMany
    @JoinColumn(name = "ligneVentes")
    private List<LigneVente> ligneVentes;
}
