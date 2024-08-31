package devsu.movements.repositories.jpa.vo;

import devsu.movements.entities.vo.MovementsAccountReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovementAccountReportRepository extends JpaRepository<MovementsAccountReportEntity, Long> {

    @Query("SELECT e FROM MovementsAccountReportEntity e WHERE e.dateMovement BETWEEN :fechaInicio AND :fechaFin AND e.idCliente =:clientId")
    List<MovementsAccountReportEntity> getDataMovements(@Param("fechaInicio") LocalDate fechaInicio,
                                                        @Param("fechaFin") LocalDate fechaFin,
                                                        @Param("clientId") Long clientId);


}
