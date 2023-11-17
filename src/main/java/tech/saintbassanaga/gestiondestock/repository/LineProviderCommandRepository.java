package tech.saintbassanaga.gestiondestock.repository;

public interface LineProviderCommandRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.LineProviderCommand, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.LineProviderCommand> {
}