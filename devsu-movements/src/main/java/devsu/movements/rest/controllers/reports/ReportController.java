package devsu.movements.rest.controllers.reports;

import devsu.movements.constants.ApiConstants;
import devsu.movements.dto.requests.reports.ReportRequestDTO;
import devsu.movements.dto.responses.ReportResponseDTO;
import devsu.movements.rest.commons.CustomResponse;
import devsu.movements.rest.controllers.generic.GenericController;
import devsu.movements.rest.exceptions.NotContentException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = ApiConstants.URL_API_REPORTS)
public class ReportController extends GenericController {

    private final CommandGateway commandGateway;
    public ReportController(QueryGateway queryGateway, CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/report1")
    public ResponseEntity<CustomResponse> getClientById(@Valid @RequestBody ReportRequestDTO request) throws NotContentException {
        log.info("request: {}", request);
        List<ReportResponseDTO> listResponse = commandGateway.sendAndWait(request);
        log.info("listResponse: {}", listResponse);
        return getResponse(listResponse);
    }
}
