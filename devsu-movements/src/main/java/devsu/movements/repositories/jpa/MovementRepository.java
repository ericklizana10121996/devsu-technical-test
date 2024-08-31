package devsu.movements.repositories.jpa;

import devsu.movements.entities.MovementEntity;
import devsu.movements.repositories.exceptions.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

    @Modifying
    @Query(value="UPDATE MovementEntity c SET c.status=false WHERE c.id = :movementId")
    int deleteLogic(@Param("movementId") Long id) throws RepositoryException;
}
