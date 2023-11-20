package tech.saintbassanaga.gestiondestock.validators;

import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto)
    {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || StringUtils.hasLength(categoryDto.getCode()))
            errors.add("Please Refill the Category code");

        return errors;
    }
}
