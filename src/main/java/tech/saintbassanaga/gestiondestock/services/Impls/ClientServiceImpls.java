package tech.saintbassanaga.gestiondestock.services.Impls;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.gestiondestock.dtos.ClientDto;
import tech.saintbassanaga.gestiondestock.exceptions.EntityNotFoundException;
import tech.saintbassanaga.gestiondestock.exceptions.ErrorCode;
import tech.saintbassanaga.gestiondestock.exceptions.InvalidEntityException;
import tech.saintbassanaga.gestiondestock.repository.ClientRepository;
import tech.saintbassanaga.gestiondestock.repository.UsersRepository;
import tech.saintbassanaga.gestiondestock.services.ClientService;
import tech.saintbassanaga.gestiondestock.validators.ClientValidator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * Service Implementation for {@link tech.saintbassanaga.gestiondestock.services.ClientService}
 */
@Getter
@Slf4j
@Service("clientServiceImpl")
public class ClientServiceImpls implements ClientService {
    private final UsersRepository usersRepository;
    private final ClientRepository clientRepository;

    public ClientServiceImpls(ClientRepository clientRepository,
                              UsersRepository usersRepository) {
        this.clientRepository = clientRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Client is not valid {}",dto);
            throw new InvalidEntityException("Article is not valid", ErrorCode.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(UUID Id) {
        if (Id == null){
            log.error("Client ID can not be NULL");
            return null;
        }
        return clientRepository.findById(Id)
                .map(ClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "There is no Client with Id =" + Id + "Found in Database",
                        ErrorCode.CLIENT_NOT_FOUND)
                );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID Id) {

        if (Id==null){
            log.error("Client Not Found");
            return;
        }
        clientRepository.deleteById(Id);
    }
}
