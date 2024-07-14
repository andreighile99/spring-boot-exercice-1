package exercise.exception.tariff;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Builder
public class TariffSearchException extends RuntimeException{

    public TariffSearchException(String message) {
        super("Tariff search has failed: " + message);
    }

    public TariffSearchException() {
        super("Tariff search has failed.");
    }

}
