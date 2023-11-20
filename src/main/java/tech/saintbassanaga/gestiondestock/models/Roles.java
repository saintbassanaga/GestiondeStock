package tech.saintbassanaga.gestiondestock.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{
    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}
