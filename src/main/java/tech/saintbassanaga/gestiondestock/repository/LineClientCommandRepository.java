package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.LineClientCommand;

import java.util.UUID;

public interface LineClientCommandRepository extends JpaRepository<LineClientCommand, UUID>, JpaSpecificationExecutor<LineClientCommand> {
}