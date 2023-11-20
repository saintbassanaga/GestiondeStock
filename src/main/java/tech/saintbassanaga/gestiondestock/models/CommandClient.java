package tech.saintbassanaga.gestiondestock.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "commandClient")
public class CommandClient extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "command_date")
    private Instant commandDate;

    @Column(name = "command_state")
    @Enumerated(EnumType.STRING)
    private CommandState commandState;

    @Column(name = "enterpriseId")
    private Integer EnterpriseId;

    @OneToMany(mappedBy = "commandClient")
    private List<LineClientCommand> lineClientCommands;


    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
