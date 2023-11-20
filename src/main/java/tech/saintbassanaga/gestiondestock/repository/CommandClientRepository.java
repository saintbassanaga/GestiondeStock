package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.CommandClient;

import java.util.UUID;

public interface CommandClientRepository extends JpaRepository<CommandClient, UUID>, JpaSpecificationExecutor<CommandClient> {
}