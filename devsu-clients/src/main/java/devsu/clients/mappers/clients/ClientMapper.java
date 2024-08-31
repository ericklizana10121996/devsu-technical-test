package devsu.clients.mappers.clients;

import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.dto.requests.ClientUpdateRequestDTO;
import devsu.clients.dto.responses.ClientResponseDTO;
import devsu.clients.entities.ClientEntity;

public interface ClientMapper {
    ClientRequestDTO toDTO(ClientCreateRequestDTO dto);
    ClientRequestDTO toDTO(ClientUpdateRequestDTO dto, Long id);
    ClientResponseDTO toResponseDTO(ClientEntity clientEntity);

    ClientEntity toEntity(ClientRequestDTO request);

 }
