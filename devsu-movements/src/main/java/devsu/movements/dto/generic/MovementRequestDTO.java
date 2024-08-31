package devsu.movements.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovementRequestDTO {
    private Long id;
    private Long accountId;
    private Double value;
}
