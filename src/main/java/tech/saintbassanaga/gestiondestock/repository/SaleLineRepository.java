package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.SaleLine;

import java.util.UUID;

public interface SaleLineRepository extends JpaRepository<SaleLine, UUID>, JpaSpecificationExecutor<SaleLine> {
}