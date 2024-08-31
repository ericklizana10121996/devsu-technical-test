package devsu.movements.dto.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MovementResponseDTO {
    private Long id;
    private String accountNumber;
    private LocalDate date;
    private Double value;
    private String type;
    private Boolean status;
}
