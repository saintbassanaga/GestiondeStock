package tech.saintbassanaga.gestiondestock.validators;

import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Please Refill the client name");
            errors.add("Please Refill the client email");
            errors.add("Please Refill the client phone number");
            errors.add("Please Refill the client lastname");
        }

        assert clientDto != null;
        if (!StringUtils.hasLength(clientDto.getName()))
            errors.add("Please refill the Client Name");
        if (!StringUtils.hasLength(clientDto.getEmail()))
            errors.add("Please refill the Client Email");
        if (!StringUtils.hasLength(clientDto.getPhoneNumber()))
            errors.add("Please refill the Client Phone Number");
        if (!StringUtils.hasLength(clientDto.getLastname()))
            errors.add("Please refill the Client last Name");


        return errors;

    }
}
