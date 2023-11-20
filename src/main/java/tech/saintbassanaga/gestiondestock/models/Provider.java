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
@Table(name = "provider")
public class Provider extends  AbstractEntity{

    @Column(name = "firstname")
    private String name;

    @Column(name = "lastname")
    private String surname;

    @Column(name = "photo")
    private String photo;

    @Embedded
    private Address address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private  String phoneNumber;

    @Column(name = "enterpriseId")
    private Integer EnterpriseId;

    @OneToMany(mappedBy = "provider")
    @ToString.Exclude
    private List<CommandProvider> commandProviders;

}
