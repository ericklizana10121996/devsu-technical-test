package devsu.movements.mappers.movements;

import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.entities.MovementEntity;

public interface MovementMapper {
    //MovementRequestDTO toDTO(MovementCreateRequestDTO dto);
    MovementResponseDTO toResponseDTO(MovementEntity movementEntity);
    MovementEntity toEntity(MovementCreateRequestDTO request);

 }
