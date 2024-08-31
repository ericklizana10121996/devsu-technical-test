package devsu.movements.mappers.movements;

import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.entities.AccountEntity;
import devsu.movements.entities.MovementEntity;
import org.springframework.stereotype.Component;

import static devsu.movements.commons.Util.convertToNull;

@Component
public class MovementMapperImpl implements MovementMapper {
    @Override
    public MovementResponseDTO toResponseDTO(MovementEntity movementEntity) {
        return MovementResponseDTO.builder()
                .id(movementEntity.getId())
                .accountNumber(movementEntity.getAccount().getAccountNumber())
                .date(movementEntity.getDate())
                .type(movementEntity.getType())
                .value(movementEntity.getValue())
                .status(movementEntity.getStatus())
                .build();
    }

    @Override
    public MovementEntity toEntity(MovementCreateRequestDTO requestDTO) {
        return MovementEntity.builder()
                .account(AccountEntity.builder().id(requestDTO.accountId()).build())
                .type(requestDTO.typeMovement())
                .value(requestDTO.value())
                .build();
    }
}
