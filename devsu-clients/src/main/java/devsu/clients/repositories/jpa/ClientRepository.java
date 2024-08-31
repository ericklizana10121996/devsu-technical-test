package devsu.clients.repositories.jpa;

import devsu.clients.entities.ClientEntity;
import devsu.clients.repositories.exceptions.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Modifying
    @Query(value="UPDATE ClientEntity c SET c.status=false WHERE c.id = :clientId")
    int deleteLogic(@Param("clientId") Long id) throws RepositoryException;
}
