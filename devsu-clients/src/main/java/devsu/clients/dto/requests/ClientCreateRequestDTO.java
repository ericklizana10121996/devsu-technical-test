package devsu.clients.dto.requests;

import static devsu.clients.constants.Constants.MAX_LENGTH_NAME;
import static devsu.clients.constants.Constants.MAX_LENGTH_PHONE;
import static devsu.clients.constants.Constants.PATTERN_REGEX_PHONE;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record ClientCreateRequestDTO(
        @NotNull(message = "{client.name.required}")
        @Size(max = MAX_LENGTH_NAME, message = "{client.name.maxlength}")
        String name,
        @NotNull(message = "{client.address.required}")
        String address,
        @NotNull(message = "{client.phone.required}")
        @Size(max = MAX_LENGTH_PHONE, message = "{client.phone.maxlength}")
        @Pattern(regexp = PATTERN_REGEX_PHONE , message = "{client.phone.pattern.message}")
        String phone,
        @NotNull(message = "{client.password.required}")
        String password) {
}
