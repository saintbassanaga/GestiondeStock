package tech.saintbassanaga.gestiondestock.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class Users extends AbstractEntity{
    @Column(name = "firstname")
    private String name ;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "borndate")
    private Instant bornDate;
    @Column(name = "password")
    private String password;
    @Embedded
    private Address address;
    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "enterprise_Id")
    private Enterprise enterprise;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @JsonIgnore
    private List<Roles> roles;
}
