package tech.saintbassanaga.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Client;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.Client}
 */
@Value
@Data
@Builder
public class ClientDto implements Serializable {
    UUID id;
    String name;
    String lastname;
    String photo;
    AddressDto address;
    String email;
    String phoneNumber;
    Integer enterpriseID;

    @JsonIgnore
    List<CommandClientDto> commandClient;


    public static ClientDto fromEntity(Client client){
        if (client == null)
            return null;

        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .photo(client.getPhoto())
                .address(AddressDto.fromEntity(client.getAddress()))
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .enterpriseID(client.getEnterpriseID())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null)
            return null;

        Client client = new Client();

        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setLastname(clientDto.getLastname());
        client.setPhoto(clientDto.getPhoto());
        client.setPhoto(clientDto.getPhoto());
        client.setAddress(AddressDto.toEntity(clientDto.getAddress()));
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setEnterpriseID(clientDto.getEnterpriseID());

        return client;

    }
}