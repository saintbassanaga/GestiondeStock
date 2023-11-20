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
@Table(name = "enterprise")
public class Enterprise extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Embedded
    private Address address;

    @Column(name = "fiscal_code")
    private String codeFiscal;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "siteweb")
    private String siteWeb;

    @OneToMany(mappedBy = "enterprise")
    @ToString.Exclude
    private List<Users> users;
}
