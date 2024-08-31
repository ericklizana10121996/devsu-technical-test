package devsu.clients.rest.controllers.generic;


import devsu.clients.mappers.clients.ClientMapperImpl;
import devsu.clients.rest.commons.CustomResponse;
import devsu.clients.rest.exceptions.NotContentException;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@ControllerAdvice
public abstract class GenericController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> handleGeneralException(Exception ex) {
        CustomResponse customResponse = CustomResponse.builder()
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .status(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .data(ex.getCause().getMessage())
                .build();

        return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<CustomResponse> getResponse(Object object) throws NotContentException {
        CustomResponse customResponse = CustomResponse.builder()
                .message(HttpStatus.OK.name())
                .status(HttpStatus.OK.value())
                .localDateTime(LocalDateTime.now())
                .data(object)
                .build();

        return ResponseEntity.ok(customResponse);
    }

    protected ResponseEntity<CustomResponse> getResponse(Long id) throws NotContentException {
        CustomResponse customResponse = CustomResponse.builder()
                .message(HttpStatus.OK.name())
                .status(HttpStatus.OK.value())
                .localDateTime(LocalDateTime.now())
                .data(id)
                .build();

        return ResponseEntity.ok(customResponse);
    }

}
