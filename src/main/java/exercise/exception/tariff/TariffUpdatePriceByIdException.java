package exercise.exception.tariff;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Builder
public class TariffUpdatePriceByIdException extends RuntimeException{

    public TariffUpdatePriceByIdException(String message) {
        super("Tariff price update has failed: " + message);
    }

    public TariffUpdatePriceByIdException() {
        super("Tariff price update has failed.");
    }

}
