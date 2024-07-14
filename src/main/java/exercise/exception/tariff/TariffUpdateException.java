package exercise.exception.tariff;

import lombok.Builder;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
@Builder
public class TariffUpdateException extends RuntimeException{

    public TariffUpdateException(String message) {
        super("Tariff update has failed: " + message);
    }

    public TariffUpdateException() {
        super("Tariff update has failed.");
    }

}
