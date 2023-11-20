package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.Enterprise;

import java.util.UUID;

public interface EnterpriseRepository extends JpaRepository<Enterprise, UUID>, JpaSpecificationExecutor<Enterprise> {
}