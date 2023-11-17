package tech.saintbassanaga.gestiondestock.repository;

public interface CategoryRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.Category, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.Category> {
}