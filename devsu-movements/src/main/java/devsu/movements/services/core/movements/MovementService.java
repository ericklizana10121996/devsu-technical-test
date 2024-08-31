package devsu.movements.services.core.movements;

import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.requests.movements.MovementDeleteRequestDTO;
import devsu.movements.dto.requests.movements.MovementFindByIdRequestDTO;
import devsu.movements.dto.responses.MovementResponseDTO;
import devsu.movements.services.core.generic.GenericService;

public interface MovementService extends GenericService<MovementCreateRequestDTO, MovementResponseDTO,
                    MovementFindByIdRequestDTO, MovementDeleteRequestDTO> {
}
