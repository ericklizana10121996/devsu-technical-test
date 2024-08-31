package devsu.movements.dto.requests.movements;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MovementDeleteRequestDTO(
        @NotNull(message = "{movement.id.required}")
        @Positive(message = "{movement.id.positive}")
        Long id) {
}
