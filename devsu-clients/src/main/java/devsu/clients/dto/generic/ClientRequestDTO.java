package devsu.clients.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequestDTO {
    private Long id;
    private String name;
    private String password;
    private String address;
    private String phone;
    private Integer age;
    private String gender;
    private String identityDocument;

    private Boolean status;

}
