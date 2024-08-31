package devsu.movements.dto.requests.movements;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public record MovementCreateRequestDTO(
        @NotNull(message = "{movement.accountId.required}")
        @Positive(message = "{movement.accountId.positive}")
        Long accountId,
        @NotNull(message = "{movement.value.required}")
        Double value,
        @NotNull(message = "{movement.type.required}")
        String typeMovement) {
}
