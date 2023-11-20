package tech.saintbassanaga.gestiondestock.services;

import tech.saintbassanaga.gestiondestock.dtos.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientDto save(ClientDto dto);

    ClientDto findById(UUID Id);

    List<ClientDto> findAll();

    void delete(UUID Id);
}
