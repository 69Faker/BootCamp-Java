package me.thiago.domain.repository;

import me.thiago.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface de repositório para User, usando Spring Data JPA
// Fornece métodos CRUD e consulta personalizada
public interface UserRepository extends JpaRepository<User, Long>
{
    // Método derivado para verificar existência de usuário pelo número da conta
    boolean existsByAccountNumber(String accountNumber);
}
