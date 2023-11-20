package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.dtos.AddressDto;
import tech.saintbassanaga.gestiondestock.dtos.EnterpriseDto;
import tech.saintbassanaga.gestiondestock.dtos.RolesDto;
import tech.saintbassanaga.gestiondestock.models.Users;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Users}
 */
@Value
@Builder
@Data
public class UsersDto implements Serializable {
    UUID id;
    String name;
    String lastName;
    String email;
    Instant bornDate;
    String password;
    AddressDto address;
    String photo;
    EnterpriseDto enterprise;
    List<RolesDto> roles;


    public UsersDto fromEntity(Users users) {
        if (users == null)
            return null;

        return UsersDto.builder()
                .id(users.getId())
                .name(users.getName())
                .lastName(users.getLastName())
                .email(users.getEmail())
                .bornDate(users.getBornDate())
                .address(address.fromEntity(users.getAddress()))
                .photo(users.getPhoto())
                .enterprise(enterprise.fromEntity(users.getEnterprise()))
                .build();
    }

    public Users toEntity(UsersDto usersDto)
    {
        if(usersDto == null)
            return null;

        Users users = new Users();

        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLastName(usersDto.getLastName());
        users.setEmail(usersDto.getEmail());
        users.setBornDate(usersDto.getBornDate());
        users.setAddress(address.toEntity(usersDto.getAddress()));
        users.setPassword(usersDto.getPassword());
        users.setPhoto(usersDto.getPhoto());
        users.setEnterprise(enterprise.toEntity(usersDto.getEnterprise()));
        return users;
    }
}