package devsu.movements.rest.controllers.accounts;

import devsu.movements.constants.ApiConstants;
import devsu.movements.dto.requests.accounts.AccountCreateRequestDTO;
import devsu.movements.dto.requests.accounts.AccountDeleteRequestDTO;
import devsu.movements.dto.requests.accounts.AccountFindByIdRequestDTO;
import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.requests.movements.MovementDeleteRequestDTO;
import devsu.movements.dto.responses.AccountResponseDTO;
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
@RequestMapping(path = ApiConstants.URL_API_ACCOUNTS)
public class AccountController extends GenericController {

    private final CommandGateway commandGateway;

    public AccountController(QueryGateway queryGateway, CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getClientById(@PathVariable Long id) throws NotContentException {
        AccountResponseDTO accountResponseDTO = commandGateway.sendAndWait(new AccountFindByIdRequestDTO(id));
        return getResponse(accountResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> createClient(@Valid @RequestBody
                                                       AccountCreateRequestDTO accountCreateRequestDTO) throws NotContentException {
        log.info("accountDTO {}", accountCreateRequestDTO);
        Long newId = commandGateway.sendAndWait(accountCreateRequestDTO);
        return getResponse(newId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteClient(@PathVariable Long id) throws NotContentException {
        commandGateway.sendAndWait(new AccountDeleteRequestDTO(id));
        return getResponse(id);
    }

}
