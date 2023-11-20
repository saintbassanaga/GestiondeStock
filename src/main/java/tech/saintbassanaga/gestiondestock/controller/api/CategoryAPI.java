package tech.saintbassanaga.gestiondestock.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.saintbassanaga.gestiondestock.dtos.CategoryDto;


import java.util.List;
import java.util.UUID;
/**
 *
 */

public interface CategoryAPI {

    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(CategoryDto dto);

    @GetMapping(value = "/find/byID/{categoryID}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("categoryID") UUID Id);

    @GetMapping(value ="/find/byCode/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategory") String code);

    @GetMapping(value = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();
    @DeleteMapping(value = "/delete/{Id}")
    void delete(@PathVariable("Id") UUID Id);
}
