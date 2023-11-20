package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.CommandProvider;

import java.util.UUID;

public interface CommandProviderRepository extends JpaRepository<CommandProvider, UUID>, JpaSpecificationExecutor<CommandProvider> {
}