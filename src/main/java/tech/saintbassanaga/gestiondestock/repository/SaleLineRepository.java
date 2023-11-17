package tech.saintbassanaga.gestiondestock.repository;

public interface SaleLineRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.SaleLine, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.SaleLine> {
}