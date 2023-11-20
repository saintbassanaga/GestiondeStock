package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Provider;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.Provider}
 */
@Value
@Data
@Builder
public class ProviderDto implements Serializable {
    UUID id;
    String name;
    String surname;
    String photo;
    AddressDto address;
    String email;
    String phoneNumber;
    Integer EnterpriseId;
    List<CommandProviderDto> commandProviders;

    public ProviderDto fromEntity(Provider provider) {

        if (provider == null)
            return null;

        return ProviderDto.builder()
                .id(provider.getId())
                .name(provider.getName())
                .surname(provider.getSurname())
                .photo(provider.getPhoto())
                .address(address.fromEntity(provider.getAddress()))
                .email(provider.getEmail())
                .phoneNumber(provider.getPhoneNumber())
                .EnterpriseId(provider.getEnterpriseId())
                .build();
    }

    public Provider toEntity(ProviderDto providerDto) {
        if (providerDto == null)
            return null;

        Provider provider = new Provider();

        provider.setId(providerDto.getId());
        provider.setName(providerDto.getName());
        provider.setSurname(providerDto.getSurname());
        provider.setPhoto(providerDto.getPhoto());
        provider.setAddress(address.toEntity(providerDto.getAddress()));
        provider.setEmail(providerDto.getEmail());
        provider.setPhoneNumber(providerDto.getPhoneNumber());
        provider.setEnterpriseId(providerDto.getEnterpriseId());

        return provider;
    }

}