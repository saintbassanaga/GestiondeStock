package tech.saintbassanaga.gestiondestock.services.Impls;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.saintbassanaga.gestiondestock.dtos.CategoryDto;
import tech.saintbassanaga.gestiondestock.exceptions.EntityNotFoundException;
import tech.saintbassanaga.gestiondestock.exceptions.ErrorCode;
import tech.saintbassanaga.gestiondestock.exceptions.InvalidEntityException;
import tech.saintbassanaga.gestiondestock.repository.CategoryRepository;
import tech.saintbassanaga.gestiondestock.services.CategoryService;
import tech.saintbassanaga.gestiondestock.validators.CategoryValidator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
@Getter
public class CategoryServiceImpls implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpls(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {

        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Article is not valid", ErrorCode.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.
                        save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(UUID Id) {

        if (Id == null) {
            log.error("Category ID can not be NULL");
            return null;
        }
        return categoryRepository.findById(Id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "There is no Category with Id =" + Id + "Founded in Database",
                        ErrorCode.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category code is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("There is no Category with code : " + code + " In the Database", ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID Id) {
        if (Id == null) {
            log.error("Category not found");
            return;
        }
        categoryRepository.deleteById(Id);
    }
}
