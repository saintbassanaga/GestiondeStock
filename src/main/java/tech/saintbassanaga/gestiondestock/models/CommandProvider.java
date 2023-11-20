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
@Table(name = "command_provider")
public class CommandProvider extends AbstractEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "command_date")
    private Instant commandDate;

    @Column(name = "command_state")
    @Enumerated(EnumType.STRING)
    private CommandState commandState;

    @Column(name = "enterprise_Id")
    private Integer EnterpriseId;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "commandProvider")
    @ToString.Exclude
    private List<LineProviderCommand> lineProviderCommands;

}
