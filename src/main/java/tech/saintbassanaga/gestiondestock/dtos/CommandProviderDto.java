package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.CommandProvider;
import tech.saintbassanaga.gestiondestock.models.CommandState;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.CommandProvider}
 */
@Value
@Data
@Builder
public class CommandProviderDto implements Serializable {
    UUID id;
    String code;
    Instant commandDate;
    CommandState commandState;
    Integer EnterpriseId;
    ProviderDto provider;
    List<LineProviderCommandDto> lineProviderCommands;

    public CommandProviderDto fromEntity(CommandProvider commandProvider)
    {
        if (commandProvider == null)
            return null;

        return CommandProviderDto.builder()
                .id(commandProvider.getId())
                .code(commandProvider.getCode())
                .commandDate(commandProvider.getCommandDate())
                .commandState(commandProvider.getCommandState())
                .EnterpriseId(commandProvider.getEnterpriseId())
                .provider(provider.fromEntity(commandProvider.getProvider()))
                .build();
    }

    public CommandProvider toEntity(CommandProviderDto commandProviderDto){

        CommandProvider commandProvider = new CommandProvider();

        commandProvider.setId(commandProviderDto.getId());
        commandProvider.setCode(commandProviderDto.getCode());
        commandProvider.setCommandDate(commandProviderDto.getCommandDate());
        commandProvider.setCommandState(commandProviderDto.getCommandState());
        commandProvider.setEnterpriseId(commandProviderDto.getEnterpriseId());
        commandProvider.setProvider(provider.toEntity(commandProviderDto.getProvider()));
        return commandProvider;
    }
}