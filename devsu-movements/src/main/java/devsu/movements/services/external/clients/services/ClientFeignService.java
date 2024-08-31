package devsu.movements.services.external.clients.services;

import devsu.movements.services.exceptions.ServiceException;
import devsu.movements.services.external.clients.dto.CustomResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static devsu.movements.services.constants.ServiceConstants.CLIENT_NOT_FOUND;

@FeignClient(name = "ClientFeignService", url = "http://localhost:8085/devsu-clients/api/v1/clients")
public interface ClientFeignService {

    @GetMapping("/{id}")
    ResponseEntity<CustomResponse> getFeignClient(@PathVariable Long id);

    default CustomResponse getClient(Long clientId) throws ServiceException {
        try {
            ResponseEntity<CustomResponse> response = getFeignClient(clientId);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new ServiceException(CLIENT_NOT_FOUND + clientId, e.getCause());
        }

        return null;
    }
}
