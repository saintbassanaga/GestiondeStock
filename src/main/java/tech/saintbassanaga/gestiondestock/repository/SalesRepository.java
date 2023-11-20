package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.Sales;

import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sales, UUID>, JpaSpecificationExecutor<Sales> {
}