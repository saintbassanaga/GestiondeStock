package tech.saintbassanaga.gestiondestock.repository;

public interface LineClientCommandRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.LineClientCommand, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.LineClientCommand> {
}