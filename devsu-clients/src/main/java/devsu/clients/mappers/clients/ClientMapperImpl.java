package devsu.clients.mappers.clients;

import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.dto.requests.ClientUpdateRequestDTO;
import devsu.clients.dto.responses.ClientResponseDTO;
import devsu.clients.entities.ClientEntity;
import org.springframework.stereotype.Component;

import static devsu.clients.commons.Util.convertToNull;

@Component
public class ClientMapperImpl implements ClientMapper{
    @Override
    public ClientRequestDTO toDTO(ClientCreateRequestDTO request) {
        return ClientRequestDTO
                .builder()
                .name(request.name())
                .address(request.address())
                .phone(request.phone())
                .password(request.password())
                .build();
    }

    @Override
    public ClientRequestDTO toDTO(ClientUpdateRequestDTO request, Long id) {
        return ClientRequestDTO
                .builder()
                .id(id)
                .name(request.name())
                .address(request.address())
                .age(request.age())
                .phone(request.phone())
                .password(request.password())
                //.status(Boolean.TRUE)
                //.gender(request.gender())
                .build();
    }

    @Override
    public ClientResponseDTO toResponseDTO(ClientEntity clientEntity) {
        return ClientResponseDTO.builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .address(clientEntity.getAddress())
                .phone(clientEntity.getPhone())
                .status(clientEntity.getStatus())
                .build();
    }

    @Override
    public ClientEntity toEntity(ClientRequestDTO requestDTO) {
        return ClientEntity.builder()
                .id(requestDTO.getId())
                .name(requestDTO.getName())
                .phone(requestDTO.getPhone())
                .address(requestDTO.getAddress())
                .password(requestDTO.getPassword())
                .identityDocument(requestDTO.getIdentityDocument())
                .age(requestDTO.getAge())
                .status(convertToNull(String.valueOf(requestDTO.getStatus())))
                .build();
    }
}
