package devsu.movements.services.external.clients.dto;

public record ClientResponseDTO(
    Long id,
    String name,
    String address,
    String gender,
    String phone,
    Boolean status
) {
}
