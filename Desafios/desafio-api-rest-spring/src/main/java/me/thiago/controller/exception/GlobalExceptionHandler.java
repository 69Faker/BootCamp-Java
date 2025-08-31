package me.thiago.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
// Trata exceções de forma global para todos os controllers
public class GlobalExceptionHandler
{
    private final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    // Captura exceções de negócio e retorna 422 Unprocessable Entity
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException)
    {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    // Captura exceções quando um recurso não é encontrado e retorna 404 Not Found
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException)
    {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    // Captura quaisquer outras exceções inesperadas e retorna 500 Internal Server Error
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException)
    {
        var message = "Unexpected server error, see the logs.";
        logger.error(message, unexpectedException); // Log detalhado da exceção
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
