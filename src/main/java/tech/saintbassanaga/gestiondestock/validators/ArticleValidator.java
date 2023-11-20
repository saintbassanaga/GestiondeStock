package tech.saintbassanaga.gestiondestock.validators;

import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){

        List<String> errors = new ArrayList<>();

        if (articleDto == null){
            errors.add("Please Refill product Code");
            errors.add("Please Refill product Designation");
            errors.add("Please Refill product the Price per Unit HT");
            errors.add("Please Refill product TVA");
            errors.add("Please Refill product The Unit price TTC");
            errors.add("Please Refill product The product Category");
        }

        assert articleDto != null;
        if ((!StringUtils.hasLength(articleDto.getCodeArticle())))
            errors.add("Please Refill the product code");
        if ((!StringUtils.hasLength(articleDto.getDesignation())))
            errors.add("Please Refill the product designation");
        if (articleDto.getUnitPriceTTC() == null) errors.add("Please Refill the product TTC price");
        if (articleDto.getUnitPriceHt() == null) errors.add("Please Refill the product HT price");
        if (articleDto.getTauxTva() == null) errors.add("Please Refill the product TVA");
        if (articleDto.getCategory() == null) errors.add("Please Refill the product Category");

        return errors;

    }
}
