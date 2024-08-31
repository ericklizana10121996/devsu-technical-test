package devsu.movements.repositories.jpa;

import devsu.movements.entities.AccountEntity;
import devsu.movements.repositories.exceptions.RepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Modifying
    @Query(value="UPDATE AccountEntity c SET c.status=false WHERE c.id = :accountId")
    int deleteLogic(@Param("accountId") Long id) throws RepositoryException;
}
