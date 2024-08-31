package devsu.movements.dto.requests.accounts;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AccountFindByIdRequestDTO(
        @NotNull(message = "{account.id.required}")
        @Positive(message = "{account.id.positive}")
        Long id) {
}
