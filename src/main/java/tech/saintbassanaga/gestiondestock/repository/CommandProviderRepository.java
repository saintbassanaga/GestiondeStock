package tech.saintbassanaga.gestiondestock.repository;

public interface CommandProviderRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.CommandProvider, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.CommandProvider> {
}