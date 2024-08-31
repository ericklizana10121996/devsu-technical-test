package devsu.movements.dto.requests.accounts;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import static devsu.movements.constants.Constants.*;


public record AccountCreateRequestDTO(
        @NotNull(message = "{account.clientId.required}")
        @Positive(message = "{account.clientId.positive}")
        Long clientId,
//        @NotNull(message = "{account.clientId.required}")
//        String accountNumber,
        @NotNull(message = "{account.type.required}")
        String accountType,
        @NotNull(message = "{account.initialBalance.required}")
        @Positive(message = "{account.initialBalance.positive}")
        Double initialBalance) {
}
