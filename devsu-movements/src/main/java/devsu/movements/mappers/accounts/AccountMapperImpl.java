package devsu.movements.mappers.accounts;

import devsu.movements.dto.requests.accounts.AccountCreateRequestDTO;
import devsu.movements.dto.responses.AccountResponseDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.entities.AccountEntity;
import devsu.movements.entities.MovementEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public AccountResponseDTO toResponseDTO(AccountEntity accountEntity) {
        return AccountResponseDTO.builder()
                .id(accountEntity.getId())
                .accountNumber(accountEntity.getAccountNumber())
                .initialBalance(accountEntity.getInitialBalance())
                .currentBalance(accountEntity.getCurrentBalance())
                .accountType(accountEntity.getType())
                .status(accountEntity.getStatus())
                .build();
    }

    @Override
    public AccountEntity toEntity(AccountCreateRequestDTO requestDTO) {
        return AccountEntity.builder()
                .initialBalance(requestDTO.initialBalance())
                .currentBalance(requestDTO.initialBalance())
                .type(requestDTO.accountType())
                .clientId(requestDTO.clientId())
                .build();
    }
}
