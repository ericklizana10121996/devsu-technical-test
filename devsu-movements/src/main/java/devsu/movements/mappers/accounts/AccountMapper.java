package devsu.movements.mappers.accounts;

import devsu.movements.dto.requests.accounts.AccountCreateRequestDTO;
import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.responses.AccountResponseDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.entities.AccountEntity;
import devsu.movements.entities.MovementEntity;

public interface AccountMapper {
    //MovementRequestDTO toDTO(MovementCreateRequestDTO dto);
    AccountResponseDTO toResponseDTO(AccountEntity accountEntity);
    AccountEntity toEntity(AccountCreateRequestDTO request);

 }
