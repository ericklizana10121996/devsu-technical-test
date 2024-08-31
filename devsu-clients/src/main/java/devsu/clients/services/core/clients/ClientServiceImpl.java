package devsu.clients.services.core.clients;

import devsu.clients.dto.generic.ClientRequestDTO;
import devsu.clients.dto.requests.ClientCreateRequestDTO;
import devsu.clients.dto.requests.ClientDeleteRequestDTO;
import devsu.clients.dto.requests.ClientFindByIdRequestDTO;
import devsu.clients.dto.requests.ClientUpdateRequestDTO;
import devsu.clients.dto.responses.ClientResponseDTO;
import devsu.clients.entities.ClientEntity;
import devsu.clients.mappers.clients.ClientMapper;
import devsu.clients.repositories.jpa.ClientRepository;
import devsu.clients.services.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import static devsu.clients.services.constants.ServiceConstants.CLIENT_NOT_FOUND;
import static devsu.clients.services.constants.ServiceConstants.CLIENT_MESSAGE_ADD;
import static devsu.clients.services.constants.ServiceConstants.CLIENT_MESSAGE_UPDATE;
import static devsu.clients.services.constants.ServiceConstants.ERROR_PROCESS_REPOSITORY;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(final ClientRepository clientRepository,
                             final ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @CommandHandler
    @Override
    public ClientResponseDTO findById(ClientFindByIdRequestDTO req) throws ServiceException {
        log.info("findById function");
        return clientMapper.toResponseDTO(clientRepository.findById(req.id()).filter(ClientEntity::isActive).orElseThrow(() -> new ServiceException(CLIENT_NOT_FOUND + req.id())));
    }

    @CommandHandler
    @Override
    public Long save(ClientCreateRequestDTO clientCreateRequestDTO) throws ServiceException {
        ClientRequestDTO clientRequestDTO = clientMapper.toDTO(clientCreateRequestDTO);
        ClientEntity clientEntity = clientMapper.toEntity(clientRequestDTO);
        log.info("clientRequestDTO {}", clientRequestDTO);

        clientRepository.save(clientEntity);
        log.info(CLIENT_MESSAGE_ADD, clientEntity);
        return clientEntity.getId();
    }

    @CommandHandler
    @Override
    public Long update(ClientRequestDTO clientRequestDTO) throws ServiceException {
        ClientEntity clientTempEntity = clientRepository.findById(clientRequestDTO.getId())
                                    .orElseThrow(() -> new ServiceException(
                                            CLIENT_NOT_FOUND + clientRequestDTO.getId()
                                    ));

        clientRequestDTO.setStatus(clientTempEntity.getStatus());
        ClientEntity clientEntity = clientMapper.toEntity(clientRequestDTO);
        clientRepository.save(clientEntity);
        log.info(CLIENT_MESSAGE_UPDATE, clientEntity);

        return clientEntity.getId();
    }

    /**
     * function delete for clients
     * @param @req -> ClientFindByIdRequestDTO
     * @return boolean
     * @throws ServiceException
     */
    @CommandHandler
    @Override
    public Boolean delete(ClientDeleteRequestDTO req) throws ServiceException {
        clientRepository.findById(req.id())
                .filter(ClientEntity::isActive)
                .orElseThrow(() -> new ServiceException(
                    CLIENT_NOT_FOUND + req.id()
                ));

        try {
            return clientRepository.deleteLogic(req.id()) > 0;
        } catch (Exception e) {
            throw new ServiceException(ERROR_PROCESS_REPOSITORY+ req.id(), e.getCause());
        }
    }
}
