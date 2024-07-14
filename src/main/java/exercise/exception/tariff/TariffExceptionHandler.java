package exercise.exception.tariff;

import exercise.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TariffExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TariffCreateException.class)
    public ResponseEntity<Object> handleException(TariffCreateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(TariffSearchException.class)
    public ResponseEntity<Object> handleException(TariffSearchException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }

}
