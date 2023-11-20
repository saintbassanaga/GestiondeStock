package tech.saintbassanaga.gestiondestock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.saintbassanaga.gestiondestock.controller.api.ClientAPI;
import tech.saintbassanaga.gestiondestock.dtos.ClientDto;
import tech.saintbassanaga.gestiondestock.services.ClientService;

import java.util.List;
import java.util.UUID;

import static tech.saintbassanaga.gestiondestock.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/clients")
public class ClientController implements ClientAPI {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(UUID Id) {
        return clientService.findById(Id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(UUID Id) {
        clientService.delete(Id);
    }
}
