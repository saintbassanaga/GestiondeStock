package tech.saintbassanaga.gestiondestock.repository;

public interface ArticleRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.Article, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.Article> {
}