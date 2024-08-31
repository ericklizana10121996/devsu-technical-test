package devsu.movements.dto.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Double currentBalance;
    private Boolean status;
}
