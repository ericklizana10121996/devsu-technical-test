package devsu.clients.application.commands;

import com.intuit.karate.core.When;
import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.entities.ClientEntity;
import devsu.clients.mappers.clients.ClientMapper;
import devsu.clients.repositories.jpa.ClientRepository;
import devsu.clients.services.core.clients.ClientService;
import devsu.clients.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static devsu.clients.services.constants.ServiceConstants.CLIENT_MESSAGE_ADD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateClientRequestHandlerTest {
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;



    @Test
    void createClientTest() throws ServiceException {
        Long clientId = 1L;
        ClientCreateRequestDTO requestDTO = mock(ClientCreateRequestDTO.class);
        ClientEntity clientEntity = mock(ClientEntity.class);
        ClientRequestDTO clientRequestDTO = mock(ClientRequestDTO.class);

        when(clientMapper.toDTO(requestDTO)).thenReturn(clientRequestDTO);
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(clientEntity);

        Long result = clientService.save(requestDTO);
        assertEquals(result, clientId);
        verify(clientRepository, times(1)).save(clientEntity);
    }
}
