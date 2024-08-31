package devsu.movements.services.external.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class CustomResponse {
    private int status;
    private String message;
    private ClientResponseDTO data;
    private LocalDateTime localDateTime;
}
