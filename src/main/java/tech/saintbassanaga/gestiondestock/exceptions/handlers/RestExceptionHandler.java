package tech.saintbassanaga.gestiondestock.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.saintbassanaga.gestiondestock.exceptions.EntityNotFoundException;
import tech.saintbassanaga.gestiondestock.exceptions.ErrorCode;
import tech.saintbassanaga.gestiondestock.exceptions.InvalidEntityException;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  //  public  ErrorDto errorDto;
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final var errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return  new ResponseEntity<>(errorDto,notFound);
    }
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        var errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return  new ResponseEntity<>(errorDto,notFound);
    }
}
