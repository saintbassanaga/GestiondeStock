package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.CommandClient;
import tech.saintbassanaga.gestiondestock.models.CommandState;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.CommandClient}
 */
@Value
@Data
@Builder
public class CommandClientDto implements Serializable {
    UUID id;
    String code;
    Instant commandDate;
    CommandState commandState;
    Integer EnterpriseId;
    ClientDto client;
    List<LineClientCommandDto> lineClientCommands;


    public CommandClientDto fromEntity(CommandClient commandClient){
        if (commandClient == null)
            return null;

        return CommandClientDto.builder()
                .id(commandClient.getId())
                .code(commandClient.getCode())
                .commandDate(commandClient.getCommandDate())
                .commandState(commandClient.getCommandState())
                .EnterpriseId(commandClient.getEnterpriseId())
                .client(ClientDto.fromEntity(commandClient.getClient()))
                .build();
    }

    public CommandClient toEntity(CommandClientDto commandClientDto){

        if (commandClientDto == null)
            return null;

        CommandClient commandClient = new CommandClient();

        commandClient.setId(commandClientDto.getId());
        commandClient.setCode(commandClientDto.getCode());
        commandClient.setCommandDate(commandClientDto.getCommandDate());
        commandClient.setCommandState(commandClientDto.getCommandState());
        commandClient.setEnterpriseId(commandClient.getEnterpriseId());
        commandClient.setClient(ClientDto.toEntity(commandClientDto.getClient()));

        return commandClient;
    }
}