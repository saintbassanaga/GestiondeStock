package tech.saintbassanaga.gestiondestock.repository;

public interface CommandClientRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.CommandClient, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.CommandClient> {
}