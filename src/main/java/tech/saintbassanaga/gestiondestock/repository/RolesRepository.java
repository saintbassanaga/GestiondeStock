package tech.saintbassanaga.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.gestiondestock.models.Roles;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID>, JpaSpecificationExecutor<Roles> {
}