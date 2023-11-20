package tech.saintbassanaga.gestiondestock.services;

import tech.saintbassanaga.gestiondestock.dtos.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto save(CategoryDto dto);
    CategoryDto findById(UUID Id);
    CategoryDto findByCodeCategory(String code);
    List<CategoryDto> findAll();
    void delete(UUID Id);
}
