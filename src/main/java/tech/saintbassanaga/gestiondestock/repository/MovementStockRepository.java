package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.MovementStock;

import java.util.UUID;

public interface MovementStockRepository extends JpaRepository<MovementStock, UUID>, JpaSpecificationExecutor<MovementStock> {
}