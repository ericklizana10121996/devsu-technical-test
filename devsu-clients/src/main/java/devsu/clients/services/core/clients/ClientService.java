package devsu.clients.services.core.clients;

import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.dto.requests.ClientDeleteRequestDTO;
import devsu.clients.dto.requests.ClientFindByIdRequestDTO;
import devsu.clients.dto.requests.ClientUpdateRequestDTO;
import devsu.clients.dto.responses.ClientResponseDTO;
import devsu.clients.services.core.generic.GenericService;

public interface ClientService extends GenericService<ClientCreateRequestDTO, ClientRequestDTO,
                                            ClientResponseDTO, ClientFindByIdRequestDTO, ClientDeleteRequestDTO> {
}
