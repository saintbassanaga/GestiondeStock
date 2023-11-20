package tech.saintbassanaga.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import tech.saintbassanaga.gestiondestock.models.Category;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link tech.saintbassanaga.gestiondestock.models.Category}
 */
@Value
@Data
@Builder
public class CategoryDto implements Serializable {
    UUID id;
    String code;
    String designation;
    Integer enterpriseId;
    @JsonIgnore
    List<ArticleDto> articles;


    public static CategoryDto fromEntity(Category category){
        if(category == null)
            return null;

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .enterpriseId(category.getEnterpriseId())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null)
            return null;

        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setEnterpriseId(categoryDto.getEnterpriseId());

        return category;
    }
}