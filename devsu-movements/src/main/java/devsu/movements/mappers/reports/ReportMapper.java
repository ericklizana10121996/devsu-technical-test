package devsu.movements.mappers.reports;

import devsu.movements.constants.Constants;
import devsu.movements.dto.responses.ReportResponseDTO;
import devsu.movements.entities.vo.MovementsAccountReportEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ReportMapper {

    public ReportResponseDTO toResponseDTO(MovementsAccountReportEntity reportEntity) {
        return ReportResponseDTO.builder()
                .accountNumber(reportEntity.getAccountNumber())
                .dateMovement(reportEntity.getDateMovement().format(DateTimeFormatter.ofPattern(Constants.STR_FORMAT_DATE)))
                .client(reportEntity.getClient())
                .initialBalance(reportEntity.getInitialBalance())
                .statusMovement(reportEntity.getStatusMovement())
                .movement(reportEntity.getMovement())
                .currentBalance(reportEntity.getCurrentBalance())
                .build();
    }


    public List<ReportResponseDTO> toLstDTO(List<MovementsAccountReportEntity> lst) {
        // TODO Auto-generated method stub
        return lst.stream().map(this::toResponseDTO).toList();
    }


}
