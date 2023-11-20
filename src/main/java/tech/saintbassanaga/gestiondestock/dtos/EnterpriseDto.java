package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Enterprise;
import tech.saintbassanaga.gestiondestock.models.Users;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.Enterprise}
 */
@Value
@Builder
@Data
public class EnterpriseDto implements Serializable {
    UUID id;
    String nom;
    String description;
    AddressDto address;
    String codeFiscal;
    String photo;
    String email;
    String phoneNumber;
    String siteWeb;
    List<UsersDto> users;

    public EnterpriseDto fromEntity(Enterprise enterprise) {

        if (enterprise == null)
            return null;

        return  EnterpriseDto.builder()
                .id(enterprise.getId())
                .nom(enterprise.getNom())
                .description(enterprise.getDescription())
                .address(address.fromEntity(enterprise.getAddress()))
                .codeFiscal(enterprise.getCodeFiscal())
                .photo(enterprise.getPhoto())
                .email(enterprise.getEmail())
                .phoneNumber(enterprise.getPhoneNumber())
                .siteWeb(enterprise.getSiteWeb())
                .build();

    }

    public Enterprise toEntity(EnterpriseDto enterpriseDto) {

        if(enterpriseDto == null)
            return null;

        Enterprise enterprise = new Enterprise();

        enterprise.setId(enterpriseDto.getId());
        enterprise.setNom(enterpriseDto.getNom());
        enterprise.setDescription(enterprise.getDescription());
        enterprise.setAddress(address.toEntity(enterpriseDto.getAddress()));
        enterprise.setCodeFiscal(enterpriseDto.getCodeFiscal());
        enterprise.setPhoto(enterpriseDto.getPhoto());
        enterprise.setEmail(enterpriseDto.getEmail());
        enterprise.setPhoneNumber(enterpriseDto.getPhoneNumber());
        enterprise.setSiteWeb(enterpriseDto.getSiteWeb());

        return enterprise;
    }
}