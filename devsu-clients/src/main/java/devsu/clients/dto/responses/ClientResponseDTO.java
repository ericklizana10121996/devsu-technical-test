package devsu.clients.dto.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String gender;
    private String phone;
    private Boolean status;
}
