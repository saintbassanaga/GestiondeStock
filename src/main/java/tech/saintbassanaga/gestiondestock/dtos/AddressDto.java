package tech.saintbassanaga.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Address;

import java.io.Serializable;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.dtos.AddressDto}
 */
@Value
@Data
@Builder
public class AddressDto implements Serializable {
    String address1;
    String address2;
    String city;
    String postalCode;
    String country;


    public static AddressDto fromEntity(Address address){
        if (address == null)
            return null;

        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .city(address.getCity())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }

    public static Address toEntity(AddressDto addressDto){

        if (addressDto == null)
            return null;

        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setCity(addressDto.city);
        address.setCountry(addressDto.getCountry());
        address.setPostalCode(addressDto.getPostalCode());

        return address;
    }
}