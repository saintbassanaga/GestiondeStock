package tech.saintbassanaga.gestiondestock.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.saintbassanaga.gestiondestock.controller.api.CategoryAPI;
import tech.saintbassanaga.gestiondestock.dtos.CategoryDto;

import java.util.List;
import java.util.UUID;

import static tech.saintbassanaga.gestiondestock.utils.Constants.APP_ROOT;

@RestController
@RequestMapping( path = APP_ROOT + "/categories/")
public class CategoryController implements CategoryAPI {
    @Override
    public CategoryDto save(CategoryDto dto) {
        return null;
    }

    @Override
    public CategoryDto findById(UUID Id) {
        return null;
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        return null;
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public void delete(UUID Id) {

    }
}
