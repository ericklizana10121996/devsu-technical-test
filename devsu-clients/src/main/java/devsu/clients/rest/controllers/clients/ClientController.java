package devsu.clients.rest.controllers.clients;

import devsu.clients.constants.ApiConstants;
import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.dto.requests.ClientDeleteRequestDTO;
import devsu.clients.dto.requests.ClientFindByIdRequestDTO;
import devsu.clients.dto.requests.ClientUpdateRequestDTO;
import devsu.clients.dto.responses.ClientResponseDTO;
import devsu.clients.mappers.clients.ClientMapper;
import devsu.clients.mappers.clients.ClientMapperImpl;
import devsu.clients.rest.commons.CustomResponse;
import devsu.clients.rest.controllers.generic.GenericController;
import devsu.clients.rest.exceptions.ControllerException;
import devsu.clients.rest.exceptions.NotContentException;
import devsu.clients.services.core.clients.ClientService;
import devsu.clients.services.exceptions.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = ApiConstants.URL_API_CLIENTS)
public class ClientController extends GenericController {

    //private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;
    private final ClientMapper clientMapper;


    public ClientController(QueryGateway queryGateway, CommandGateway commandGateway, ClientMapper clientMapper) {
        //this.queryGateway = queryGateway;
        this.commandGateway = commandGateway;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getClientById(@PathVariable Long id) throws NotContentException {
        ClientResponseDTO clientResponseDTO = commandGateway.sendAndWait(new ClientFindByIdRequestDTO(id));
        return getResponse(clientResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> createClient(@Valid @RequestBody ClientCreateRequestDTO clientCreateRequestDTO) throws NotContentException {
        log.info("clientDT0 {}", clientCreateRequestDTO);
        Long newId = commandGateway.sendAndWait(clientCreateRequestDTO);
        return getResponse(newId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateClient(@Valid @RequestBody ClientUpdateRequestDTO clientUpdateRequestDTO,
                                             @PathVariable Long id) throws NotContentException {
        ClientRequestDTO clientRequestDTO = clientMapper.toDTO(clientUpdateRequestDTO, id);
        log.info("clientRequestDTO {}", clientRequestDTO);

        return getResponse(commandGateway.sendAndWait(clientRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteClient(@PathVariable Long id) throws NotContentException {
        commandGateway.sendAndWait(new ClientDeleteRequestDTO(id));
        return getResponse(id);
    }

}
