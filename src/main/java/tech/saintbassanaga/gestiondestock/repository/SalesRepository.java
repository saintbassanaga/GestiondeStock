package tech.saintbassanaga.gestiondestock.repository;

public interface SalesRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.Sales, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.Sales> {
}