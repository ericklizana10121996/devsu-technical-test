package devsu.clients.dto.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ClientFindByIdRequestDTO(
        @NotNull(message = "{client.id.required}")
        @Positive(message = "{client.id.positive}")
        Long id) {
}
