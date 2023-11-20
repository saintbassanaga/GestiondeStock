package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "client")
public class Client extends AbstractEntity{
    @Column(name = "firstname")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;

    @Column(name = "phone_number")
    private  String phoneNumber;


    @Column(name = "enterprise_id")
    private Integer enterpriseID;

    @OneToMany(mappedBy = "client")
    private List<CommandClient> commandClient;
}
