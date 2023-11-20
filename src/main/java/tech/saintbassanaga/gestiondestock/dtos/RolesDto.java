package tech.saintbassanaga.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Roles;
import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.Roles}
 */
@Value
@Data
@Builder
public class RolesDto implements Serializable {
    UUID id;
    String roleName;

    @JsonIgnore
    UsersDto users;

    public RolesDto fromEntity(Roles roles){
        if (roles == null) {
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null)
            return null;
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        return roles;
    }
}