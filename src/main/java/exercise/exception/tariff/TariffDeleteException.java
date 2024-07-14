package exercise.exception.tariff;

import lombok.Builder;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
@Builder
public class TariffDeleteException extends RuntimeException{

    public TariffDeleteException(String message) {
        super("Tariff deletion has failed: " + message);
    }

    public TariffDeleteException() {
        super("Tariff deletion has failed.");
    }

}
