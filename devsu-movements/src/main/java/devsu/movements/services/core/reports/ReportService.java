package devsu.movements.services.core.reports;

import devsu.movements.dto.requests.movements.MovementFindByIdRequestDTO;
import devsu.movements.dto.requests.reports.ReportRequestDTO;
import devsu.movements.dto.responses.ReportResponseDTO;
import devsu.movements.entities.vo.MovementsAccountReportEntity;
import devsu.movements.mappers.reports.ReportMapper;
import devsu.movements.repositories.jpa.vo.MovementAccountReportRepository;
import devsu.movements.services.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static devsu.movements.services.constants.ServiceConstants.MOVEMENT_NOT_FOUND;

@Slf4j
@Service
public class ReportService {

    private final ReportMapper reportMapper;
    private final MovementAccountReportRepository reportRepository;

    public ReportService (final ReportMapper reportMapper,
                          final MovementAccountReportRepository reportRepository) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
    }

    @CommandHandler
    public List<ReportResponseDTO> getReportMovementsForClient(ReportRequestDTO req) throws ServiceException {
        log.info("getReportMovementsForClient function");
        List<MovementsAccountReportEntity> lstMovements = reportRepository.getDataMovements(req.startDate(), req.endDate(), req.clientId());
        log.info("lstMov: {}", lstMovements);
        return reportMapper.toLstDTO(lstMovements);
    }
}
