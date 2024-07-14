package exercise.exception.tariff;

import lombok.Builder;

@Builder
public class TariffCreateException extends RuntimeException{

    public TariffCreateException(String message) {
        super("Tariff creation has failed: " + message);
    }

    public TariffCreateException() {
        super("Tariff creation has failed.");
    }

}
