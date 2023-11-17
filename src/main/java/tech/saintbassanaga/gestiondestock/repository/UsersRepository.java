package tech.saintbassanaga.gestiondestock.repository;

public interface UsersRepository extends org.springframework.data.jpa.repository.JpaRepository<tech.saintbassanaga.gestiondestock.models.Users, java.util.UUID> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<tech.saintbassanaga.gestiondestock.models.Users> {
}