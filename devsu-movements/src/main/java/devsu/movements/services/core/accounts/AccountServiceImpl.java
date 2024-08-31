package devsu.movements.services.core.accounts;

import devsu.movements.dto.requests.accounts.AccountCreateRequestDTO;
import devsu.movements.dto.requests.accounts.AccountDeleteRequestDTO;
import devsu.movements.dto.requests.accounts.AccountFindByIdRequestDTO;
import devsu.movements.dto.responses.AccountResponseDTO;
import devsu.movements.entities.AccountEntity;
import devsu.movements.mappers.accounts.AccountMapper;
import devsu.movements.repositories.jpa.AccountRepository;
import devsu.movements.services.exceptions.ServiceException;
import devsu.movements.services.external.clients.dto.CustomResponse;
import devsu.movements.services.external.clients.services.ClientFeignService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static devsu.movements.services.constants.ServiceConstants.ACCOUNT_NOT_FOUND;
import static devsu.movements.services.constants.ServiceConstants.ACCOUNT_MESSAGE_ADD;
import static devsu.movements.services.constants.ServiceConstants.ERROR_PROCESS_ACCOUNT_REPOSITORY;
import static devsu.movements.services.constants.ServiceConstants.ACCOUNT_TYPE_NOT_VALID_MESSAGE;

import static devsu.movements.commons.Util.isTypeAccountValid;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ClientFeignService clientFeignService;


    public AccountServiceImpl(final AccountRepository accountRepository,
                              final AccountMapper accountMapper,
                              final ClientFeignService clientFeignService) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.clientFeignService = clientFeignService;
    }

    @CommandHandler
    @Override
    public AccountResponseDTO findById(AccountFindByIdRequestDTO req) throws ServiceException {
        log.info("findById function");
        return accountMapper.toResponseDTO(accountRepository.findById(req.id()).orElseThrow(()
                -> new ServiceException(ACCOUNT_NOT_FOUND + req.id())));
    }

    @CommandHandler
    @Override
    @Transactional
    public Long save(AccountCreateRequestDTO accountCreateRequestDTO) throws ServiceException {
        if(!isTypeAccountValid(accountCreateRequestDTO.accountType())) {
            throw new ServiceException(ACCOUNT_TYPE_NOT_VALID_MESSAGE + accountCreateRequestDTO.accountType());
        }
        clientFeignService.getClient(accountCreateRequestDTO.clientId());

        AccountEntity accountEntity = accountMapper.toEntity(accountCreateRequestDTO);
        accountEntity.setType(accountCreateRequestDTO.accountType().toUpperCase());
        accountRepository.save(accountEntity);
        log.info(ACCOUNT_MESSAGE_ADD, accountEntity);
        return accountEntity.getId();
    }

    /**
     * function delete for clients
     * @param @req -> ClientFindByIdRequestDTO
     * @return boolean
     * @throws ServiceException
     */
    @CommandHandler
    @Override
    public Boolean delete(AccountDeleteRequestDTO req) throws ServiceException {
        accountRepository.findById(req.id())
                .filter(AccountEntity::isActive)
                .filter(AccountEntity::isCurrentBalanceZero)
                .orElseThrow(() -> new ServiceException(
                        ACCOUNT_NOT_FOUND + req.id()
                ));

        try {
            return accountRepository.deleteLogic(req.id()) > 0;
        } catch (Exception e) {
            throw new ServiceException(ERROR_PROCESS_ACCOUNT_REPOSITORY+ req.id(), e.getCause());
        }
    }
}
