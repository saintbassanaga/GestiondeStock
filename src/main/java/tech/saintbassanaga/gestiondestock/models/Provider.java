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
@Table(name = "fournisseur")
public class Fournisseur extends  AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "photo")
    private String photo;

    @Embedded
    private Address address;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numTel")
    private  String numTel;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandFournisseur> commandFournisseur;

}
