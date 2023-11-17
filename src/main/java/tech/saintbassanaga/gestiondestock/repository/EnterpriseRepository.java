package tech.saintbassanaga.gestiondestock.repository;

public interface EnterpriseRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.Enterprise, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.Enterprise> {
}