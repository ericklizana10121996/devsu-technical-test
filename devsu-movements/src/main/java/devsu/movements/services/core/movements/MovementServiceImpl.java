package devsu.movements.services.core.movements;

import devsu.movements.commons.MovementTypeEnum;
import devsu.movements.dto.requests.movements.MovementCreateRequestDTO;
import devsu.movements.dto.requests.movements.MovementDeleteRequestDTO;
import devsu.movements.dto.requests.movements.MovementFindByIdRequestDTO;
import devsu.movements.dto.responses.MovementResponseDTO;

import devsu.movements.entities.AccountEntity;
import devsu.movements.entities.MovementEntity;
import devsu.movements.mappers.movements.MovementMapper;
import devsu.movements.repositories.jpa.AccountRepository;
import devsu.movements.repositories.jpa.MovementRepository;
import devsu.movements.services.exceptions.ServiceException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import static devsu.movements.commons.Util.isAmountValid;
import static devsu.movements.commons.Util.isTypeMovementValid;
import static devsu.movements.services.constants.ServiceConstants.*;

@Slf4j
@Service
public class MovementServiceImpl implements MovementService {
    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    private final AccountRepository accountRepository;

    public MovementServiceImpl(final MovementRepository movementRepository,
                               final MovementMapper movementMapper,
                               final AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
        this.movementMapper = movementMapper;
    }

    @CommandHandler
    @Override
    public MovementResponseDTO findById(MovementFindByIdRequestDTO req) throws ServiceException {
        log.info("findById function");
        return movementMapper.toResponseDTO(movementRepository.findById(req.id()).orElseThrow(()
                    -> new ServiceException(MOVEMENT_NOT_FOUND + req.id())));
    }

    @CommandHandler
    @Override
    @Transactional
    public Long save(MovementCreateRequestDTO movementCreateRequestDTO) throws ServiceException {

        if (!isAmountValid(movementCreateRequestDTO.value())) {
            throw new ServiceException(MOVEMENT_AMOUNT_NOT_VALID_MESSAGE + movementCreateRequestDTO.value());
        }

        if(!isTypeMovementValid(movementCreateRequestDTO.typeMovement())) {
            throw new ServiceException(MOVEMENT_TYPE_NOT_VALID_MESSAGE + movementCreateRequestDTO.typeMovement());
        }

        AccountEntity accountEntity = accountRepository.findById(movementCreateRequestDTO.accountId())
                                    .filter(AccountEntity::isActive)
                                    .orElseThrow(() -> new ServiceException(
                                            ACCOUNT_NOT_FOUND + movementCreateRequestDTO.accountId()
                                    ));

        MovementEntity movementEntity = movementMapper.toEntity(movementCreateRequestDTO);
        log.info("movementEntity, {}", movementEntity);
        movementEntity.setType(movementCreateRequestDTO.typeMovement().toUpperCase());

        log.info("movementEntity2, {}", movementEntity);

        double currentValue = movementEntity.getValue() * (movementEntity.getType().equals(MovementTypeEnum.RETIRO.name())?-1:1);
        double currentBalance  = accountEntity.getCurrentBalance() + currentValue;

        if (currentBalance < 0) {
            throw new ServiceException(MOVEMENT_NOT_PROCESS_FOR_CURRENT_BALANCE + accountEntity.getCurrentBalance());
        }

        movementEntity.setCurrentBalance(currentValue);
        //accountEntity.setInitialBalance(accountEntity.getCurrentBalance());
        accountEntity.setCurrentBalance(currentBalance);
        movementRepository.save(movementEntity);
        accountRepository.save(accountEntity);
        log.info(MOVEMENT_MESSAGE_ADD, movementEntity);
        return movementEntity.getId();
    }

    /**
     * function delete for clients
     * @param @req -> ClientFindByIdRequestDTO
     * @return boolean
     * @throws ServiceException
     */
    @CommandHandler
    @Override
    @Transactional
    public Boolean delete(MovementDeleteRequestDTO req) throws ServiceException {
        MovementEntity movementEntity = movementRepository.findById(req.id())
                                        .filter(MovementEntity::isActive)
                                        .orElseThrow(() -> new ServiceException(
                                            MOVEMENT_NOT_FOUND + req.id()
                                        ));

        AccountEntity accountEntity =  movementEntity.getAccount();
        if (!accountEntity.isActive()) { throw new ServiceException(ACCOUNT_NOT_FOUND + req.id()); }
        try {

            double currentValue = movementEntity.getValue() * (movementEntity.getType().equals(MovementTypeEnum.RETIRO.name())?1:-1);
            double currentBalance  = accountEntity.getCurrentBalance() + currentValue;

            if (currentBalance < 0) {
                throw new ServiceException(MOVEMENT_NOT_PROCESS_FOR_CURRENT_BALANCE + accountEntity.getCurrentBalance());
            }
            accountEntity.setCurrentBalance(currentBalance);
            log.info("accountEntity, {}", accountEntity);
            accountRepository.save(accountEntity);
            return movementRepository.deleteLogic(req.id()) > 0;
        } catch (Exception e) {
            throw new ServiceException(ERROR_PROCESS_MOVEMENT_REPOSITORY+ req.id(), e.getCause());
        }
    }
}
