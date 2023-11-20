package tech.saintbassanaga.gestiondestock.validators;

import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.UsersDto;

import java.util.ArrayList;
import java.util.List;
public class UserValidator {

    public static List<String> validate(UsersDto usersDto){
        List<String> errors = new ArrayList<>();

        if (usersDto == null)
        {
            errors.add("Please refill the user name");
            errors.add("Please refill the user password");
            errors.add("Please refill the user address");
            errors.add("Please refill the user email");

        }
        assert usersDto != null;
        if (!StringUtils.hasLength(usersDto.getName()))
            errors.add("Please refill the user name");
        if (!StringUtils.hasLength(usersDto.getLastName()))
            errors.add("Please refill the user lastname");
        if (!StringUtils.hasLength(usersDto.getPassword()))
            errors.add("Please refill the user password");
        if (!StringUtils.hasLength(usersDto.getEmail()))
            errors.add("Please refill the user Email");
        if (usersDto.getAddress() == null)
            errors.add("Please refill the user address");
        else {
            if (!StringUtils.hasLength(usersDto.getAddress().getAddress1()))
                errors.add("Please refill the user address");
            if (!StringUtils.hasLength(usersDto.getAddress().getCity()))
                errors.add("The City is required");
            if (!StringUtils.hasLength(usersDto.getAddress().getPostalCode()))
                errors.add("Postal Code is required");
            if (!StringUtils.hasLength(usersDto.getAddress().getCountry()))
                errors.add("Country name is required");
        }

        if (!StringUtils.hasLength(usersDto.getName()))
            errors.add("Please refill the user name");
        if (!StringUtils.hasLength(usersDto.getName()))
            errors.add("Please refill the user name");

        return errors;

    }
}
