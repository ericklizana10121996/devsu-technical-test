package devsu.movements.services.core.accounts;

import devsu.movements.dto.requests.accounts.AccountCreateRequestDTO;
import devsu.movements.dto.requests.accounts.AccountDeleteRequestDTO;
import devsu.movements.dto.requests.accounts.AccountFindByIdRequestDTO;
import devsu.movements.dto.responses.AccountResponseDTO;
import devsu.movements.services.core.generic.GenericService;

public interface AccountService extends GenericService<AccountCreateRequestDTO, AccountResponseDTO,
        AccountFindByIdRequestDTO, AccountDeleteRequestDTO> {
}
