package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.LineProviderCommand;

import java.util.UUID;

public interface LineProviderCommandRepository extends JpaRepository<LineProviderCommand, UUID>, JpaSpecificationExecutor<LineProviderCommand> {
}