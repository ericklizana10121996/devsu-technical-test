package devsu.clients.rest.commons;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomResponse {
    private int status;
    private String message;
    private Object data;
    private LocalDateTime localDateTime;
}
