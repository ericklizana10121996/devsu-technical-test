package devsu.movements.rest.controllers.movements;

import devsu.movements.constants.ApiConstants;
import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.requests.movements.MovementDeleteRequestDTO;
import devsu.movements.dto.requests.movements.MovementFindByIdRequestDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.rest.commons.CustomResponse;
import devsu.movements.rest.controllers.generic.GenericController;
import devsu.movements.rest.exceptions.NotContentException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = ApiConstants.URL_API_MOVEMENTS)
public class MovementController extends GenericController {

    private final CommandGateway commandGateway;

    public MovementController(QueryGateway queryGateway, CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getClientById(@PathVariable Long id) throws NotContentException {
        MovementResponseDTO movementResponseDTO = commandGateway.sendAndWait(new MovementFindByIdRequestDTO(id));
        return getResponse(movementResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> createClient(@Valid @RequestBody MovementCreateRequestDTO movementCreateRequestDTO) throws NotContentException {
        log.info("clientDT0 {}", movementCreateRequestDTO);
        Long newId = commandGateway.sendAndWait(movementCreateRequestDTO);
        return getResponse(newId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteClient(@PathVariable Long id) throws NotContentException {
        commandGateway.sendAndWait(new MovementDeleteRequestDTO(id));
        return getResponse(id);
    }

}
