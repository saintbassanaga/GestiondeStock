package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "commandeFournisseur")
public class CommandFournisseur extends AbstractEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "dateCommande")
    private Instant dateCommand;

    @ManyToOne
    @JoinColumn(name = "fournisseurId")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandFournisseur")
    private List<LigneCommandFournisseur> ligneCommandFournisseurs;

}
