package exercise.exception;

import exercise.exception.tariff.TariffCreateException;
import exercise.exception.tariff.TariffSearchException;
import exercise.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }
}
