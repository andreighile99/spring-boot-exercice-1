package exercise.domain.tariff.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateTariffPriceByIdValidator {

    public void validate(UpdateTariffPriceByIdCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (command.getPrice() == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
    }
}
