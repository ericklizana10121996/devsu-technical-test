package devsu.movements.dto.requests.reports;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReportRequestDTO(
        @NotNull(message = "{report.startDate.required}")
        LocalDate startDate,
        @NotNull(message = "{report.endDate.required}")
        LocalDate endDate,
        @NotNull(message = "{report.clientId.required}")
        Long clientId
) {
}
