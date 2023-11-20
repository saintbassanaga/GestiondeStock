package tech.saintbassanaga.gestiondestock.controller.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.saintbassanaga.gestiondestock.dtos.ClientDto;

import java.util.List;
import java.util.UUID;

import static tech.saintbassanaga.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientAPI {

    @PostMapping(value ="/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(ClientDto dto);

    @GetMapping(value ="/find/{Id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("Id") UUID Id);

    @GetMapping(value ="/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping("/delete/{Id}")
    void delete(@PathVariable("Id") UUID Id);
}
