package devsu.movements.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportResponseDTO {
    private String dateMovement;
    private String client;
    private String accountNumber;
    private Double initialBalance;
    private Boolean statusMovement;
    private Double movement;
    private Double currentBalance;
}
